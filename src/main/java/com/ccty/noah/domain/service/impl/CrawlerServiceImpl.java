package com.ccty.noah.domain.service.impl;

import com.ccty.noah.aop.aspect.target.NoahService;
import com.ccty.noah.base.AsyncService;
import com.ccty.noah.domain.convertor.CrawlerConvertor;
import com.ccty.noah.domain.database.ArticleDO;
import com.ccty.noah.domain.database.UserDO;
import com.ccty.noah.domain.dto.ArticleDTO;
import com.ccty.noah.domain.dto.CommentDTO;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.domain.mapper.ArticleMapper;
import com.ccty.noah.domain.mapper.CommentMapper;
import com.ccty.noah.domain.mapper.UserMapper;
import com.ccty.noah.domain.service.CrawlerService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * 爬虫服务类
 * @author 缄默
 * @date 2020/06/08
 */
@NoahService
@Slf4j
public class CrawlerServiceImpl implements CrawlerService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private CrawlerConvertor crawlerConvertor;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CommentMapper commentMapper;

    @Autowired
    private AsyncService asyncService;

    /**
     * 爬取文章
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void crawlerArticle() {
        //获取所有文章
        List<ArticleDO> articleDOS = articleMapper.queryArticles();
        //对象转换
        List<ArticleDTO> articleDTOS = crawlerConvertor.articleDOToDTO(articleDOS);
        //获取爬虫对象
        //BaseCrawler crawler = (BaseCrawler) SpringBeanUtil.getBean("QYerCrawler"); todo @Test 单元测试中无法使用
        //文章集合
        List<ArticleDTO> articleList = Lists.newArrayList();
        //用户集合
        List<UserDTO> userList = Lists.newArrayList();
        //评价集合
        List<CommentDTO> commentList = Lists.newArrayList();
        //执行爬取任务 获取文章信息
        List<CompletableFuture<List<ArticleDTO>>> tasks = Lists.newArrayList();
        StopWatch sw = new StopWatch("异步处理");
        sw.start("任务");
        //分段异步获取
        for(int i=0;i<39;i+=20){
            int j = i;
            if(articleDTOS.size()-j>20){
                tasks.add(asyncService.crawlerQYerInfo(articleDTOS.subList(j,j+=20)));
            }else{
                tasks.add(asyncService.crawlerQYerInfo(articleDTOS.subList(j,articleDTOS.size())));
            }
        }
        //获取线程处理结果
        for(CompletableFuture<List<ArticleDTO>> task : tasks){
            try{
                articleList.addAll(task.get());
            }catch(Exception e){
                log.error("获取爬取网站信息结果异常：{}",e);
            }
        }
        sw.stop();
        log.info("Elapsed time:{} " , sw.prettyPrint());
        //插入文章信息
        articleMapper.updateArticles(crawlerConvertor.articleDTOToDO(articleList));
        articleList.forEach(article->{
            //加入用户对象并去重
            userList.addAll(article.getUserDTOS());
            //加入评价对象
            commentList.addAll(article.getCommentDTOS());
        });
        //插入评论信息
        commentMapper.insertComments(crawlerConvertor.commentDTOToDO(commentList));
        //获取所有的用户id
        List<Integer> uids = userMapper.findAllUserUid();
        //用户信息去重
        List<UserDTO> userDTOS = Lists.newArrayList();
        ArrayList<UserDTO> userCollect = userList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(()
                        -> new TreeSet<>(Comparator.comparing(UserDTO::getUid))), ArrayList::new));
        userCollect.forEach(user->{
            if(!uids.contains(user.getUid())){
                userDTOS.add(user);
            }
        });
        //插入用户信息
        List<UserDO> userDOS = crawlerConvertor.userDTOToDO(userDTOS);
        if(!CollectionUtils.isEmpty(userDOS)){
            userMapper.insertUsers(userDOS);
        }
    }
}

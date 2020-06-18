package com.ccty.noah.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ccty.noah.aop.aspect.exception.NoahException;
import com.ccty.noah.constants.ExceptionType;
import com.ccty.noah.domain.dto.ArticleDTO;
import com.ccty.noah.domain.dto.CommentDTO;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.util.http.HTTPSUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * 去哪儿网爬取
 * @author 缄默
 * @date   2020/06/09
 */
@Component("QYerCrawler")
public class QYerCrawler extends BaseCrawler {

    /**
     * 获取文章信息
     * @param article 文章基本信息
     * @return 文章实体
     */
    @Override
    public ArticleDTO getArticleInfo(ArticleDTO article) {
        //获取文章内容
        String result = HTTPSUtil.doGetByUrl(article.getUrl());
        JSONObject jsonObject = JSON.parseObject(result);
        JSONObject data = jsonObject.getJSONObject("data");
        Optional.ofNullable(data).orElseThrow(()->new NoahException(
                ExceptionType.GET_QUNAER_ARTICLE_ERROR.getCode(),
                ExceptionType.GET_QUNAER_ARTICLE_ERROR.getName()));
        Collection<Object> values = data.values();
        //用户集合
        List<UserDTO> userList = Lists.newArrayList();
        //评价集合
        List<CommentDTO> commentList = Lists.newArrayList();
        for(Object detail : values){
            JSONObject paragraph = JSON.parseObject(detail.toString());
            //正文
            String content = paragraph.getString("content");
            //用户数据对象
            JSONObject userObj = paragraph.getJSONObject("user");
            //判断是否是正文 1-正文 0-评论
            if(1==paragraph.getInteger("first")){
                //赋值文章正文  处理图片路径
                article.setContent(content.replace("src","src1"));
                //赋值作者
                article.setCreator(userObj.getInteger("uid"));
            }else{
                //加入评价对象
                commentList.add(getComment(userObj,content,article));
            }
            //加入用户对象
            userList.add(getUser(userObj));
        }
        //赋值文章来源
        article.setArticleSource(CrawlerInterface.ArticleSources.QYER.getCode());
        //赋值文章评价
        article.setCommentDTOS(commentList);
        //赋值文章用户
        article.setUserDTOS(userList);
        return article;
    }

    /**
     * 获取用户对象
     * @param userObj
     * @return
     */
    private UserDTO getUser(JSONObject userObj){
        if(ObjectUtils.isEmpty(userObj)){
            return new UserDTO();
        }
        //用户对象
        UserDTO user = new UserDTO();
        //赋值用户id
        user.setUid(userObj.getInteger("uid"));
        //赋值用户名
        user.setUsername(userObj.getString("username"));
        //赋值头像地址
        user.setPictureUrl(userObj.getString("avatar"));
        //赋值用户来源
        user.setUserSource(CrawlerInterface.ArticleSources.QYER.getCode());
        return user;
    }

    /**
     * 返回评价对象
     * @param userObj
     * @param content
     * @param articleDTO
     * @return
     */
    private CommentDTO getComment(JSONObject userObj,String content,ArticleDTO articleDTO){
        if(ObjectUtils.isEmpty(articleDTO) || ObjectUtils.isEmpty(userObj) || StringUtils.isBlank(content)){
            return new CommentDTO();
        }
        //评价对象
        CommentDTO comment = new CommentDTO();
        //赋值评价 处理图片路径
        comment.setContent(content.replace("src","src1"));
        //赋值作者
        comment.setCreator(userObj.getInteger("uid"));
        //赋值文章id
        comment.setAid(articleDTO.getId());
        //评价来源
        comment.setCommentSource(CrawlerInterface.ArticleSources.QYER.getCode());
        return comment;
    }
}

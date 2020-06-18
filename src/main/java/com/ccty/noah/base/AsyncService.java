package com.ccty.noah.base;

import com.alibaba.fastjson.JSON;
import com.ccty.noah.aop.aspect.target.NoahService;
import com.ccty.noah.domain.dto.ArticleDTO;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 异步服务类
 * @author 缄默
 * @date   2020/06/16
 */
@NoahService
@Slf4j
public class AsyncService {

    @Resource
    private QYerCrawler crawler;

    @Async("taskExecutor")
    public CompletableFuture<List<ArticleDTO>> crawlerQYerInfo(List<ArticleDTO> articleDTOS) {
        log.info("执行拉取的网站数据：{}", JSON.toJSONString(articleDTOS));
        List<ArticleDTO> articleDTOList = Lists.newArrayList();
        articleDTOS.forEach(articleDTO -> articleDTOList.add(crawler.getArticleInfo(articleDTO)));
        log.info("子线程结束");
        return CompletableFuture.completedFuture(articleDTOList);
    }

    /**
     * 这里进行标注为异步任务，在执行此方法的时候，会单独开启线程来执行(并指定线程池的名字)
     * @param user
     * @return
     * @throws InterruptedException
     */
    @Async("taskExecutor")
    public CompletableFuture<String> findUser(String user) throws InterruptedException {
        log.info(user);
        Thread.sleep(3000L);
        return CompletableFuture.completedFuture(user);
    }



}

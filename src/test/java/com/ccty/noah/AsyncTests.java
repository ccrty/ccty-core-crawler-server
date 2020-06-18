package com.ccty.noah;

import com.alibaba.fastjson.JSON;
import com.ccty.noah.base.AsyncService;
import com.ccty.noah.domain.mapper.ArticleMapper;
import com.ccty.noah.domain.service.CrawlerService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class AsyncTests {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void asyncTest() throws InterruptedException, ExecutionException {
        StopWatch sw = new StopWatch("test");
        sw.start("任务一");
        List<CompletableFuture<String>> string = Lists.newArrayList();
        String s = "name";
        for(int i=0;i<3;i+=2){
            string.add(asyncService.findUser(s));
        }
        //CompletableFuture<String> page1 = asyncService.findUser("PivotalSoftware");
        //CompletableFuture<String> page2 = asyncService.findUser("CloudFoundry");
        //CompletableFuture<String> page3 = asyncService.findUser("Spring-Projects");
        //join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行
        //CompletableFuture.allOf(page1,page2,page3).join();
        for(CompletableFuture<String> task : string){
            //CompletableFuture.allOf(task).join();
            log.info("-->:{} " , task.get());
        }
        sw.stop();
        log.info("Elapsed time:{} " , sw.prettyPrint());
    }

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void test(){
        log.info("数据：{}", JSON.toJSONString(articleMapper.queryArticles()));
    }

    @Autowired
    private CrawlerService crawlerService;

    @Test
    public void test1(){
        crawlerService.crawlerArticle();
    }

}

package com.ccty.noah;

import com.ccty.noah.base.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

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
        CompletableFuture<String> page1 = asyncService.findUser("PivotalSoftware");
        CompletableFuture<String> page2 = asyncService.findUser("CloudFoundry");
        CompletableFuture<String> page3 = asyncService.findUser("Spring-Projects");
        //join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行
        CompletableFuture.allOf(page1,page2,page3).join();
        sw.stop();
        log.info("Elapsed time: " + sw.prettyPrint());
        log.info("--> " + page1.get());
        log.info("--> " + page2.get());
        log.info("--> " + page3.get());
    }

}

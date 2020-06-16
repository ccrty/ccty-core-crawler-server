package com.ccty.noah.base;

import com.ccty.noah.aop.aspect.target.NoahService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

/**
 * 异步服务类
 * @author 缄默
 * @date   2020/06/16
 */
@NoahService
@Slf4j
public class AsyncService {

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

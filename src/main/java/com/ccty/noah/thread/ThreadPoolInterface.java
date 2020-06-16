package com.ccty.noah.thread;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 线程池
 * @author 缄默
 * @date   2020/06/12
 */
public interface ThreadPoolInterface {

    /**
     * 初始化线程池
     */
    void initConcurrentThreadPool();

    /**
     * 提交单个任务
     * @param task
     * @return
     */
    <V> V submit(BaseCallable<V> task) throws InterruptedException,
            ExecutionException;

    /**
     * 提交多个任务
     * @param tasks
     * @return
     */
    <V> List<V> invokeAll(List<? extends BaseCallable<V>> tasks)
            throws InterruptedException, ExecutionException;
}

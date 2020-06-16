package com.ccty.noah.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池
 * @author 缄默
 * @date   2020/06/12
 */
public class ThreadPool implements ThreadPoolInterface {
    private ThreadPoolExecutor threadPoolExecutor;
    // 核心线程数
    private int corePoolSize = 10;
    // 最大线程数
    private int maximumPoolSize = 20;
    // 超时时间30秒
    private long keepAliveTime = 30;

    /**
     * 初始化线程池
     */
    @Override
    public void initConcurrentThreadPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(),
                namedThreadFactory);
    }

    /**
     * 提交单个任务
     * @param task
     * @param <V>
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @Override
    public <V> V submit(BaseCallable<V> task) throws InterruptedException,
            ExecutionException {
        Future<V> result = threadPoolExecutor.submit(task);
        return result.get();
    }

    /**
     * 提交多个任务
     * @param tasks
     * @param <V>
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @Override
    public <V> List<V> invokeAll(List<? extends BaseCallable<V>> tasks)
            throws InterruptedException, ExecutionException {
        List<Future<V>> tasksResult = threadPoolExecutor.invokeAll(tasks);
        List<V> resultList = new ArrayList<V>();
        for (Future<V> future : tasksResult) {
            resultList.add(future.get());
        }
        return resultList;
    }
}

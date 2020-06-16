package com.ccty.noah.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author 缄默
 * @date 2020/06/10
 */
public class ThreadTest {

    public static void main(String[] args) throws Exception {

        /*ExecutorService ser= Executors.newFixedThreadPool(2);


        Future<Integer> resultR=ser.submit(new MyThread());
        Future<Integer> resultT=ser.submit(new MyThread());


        int numR=resultR.get();
        int numT=resultT.get();

        System.out.println("rabbit  ---"+numR);
        System.out.println("tortoise  ---"+numT);

        //停止服务
        ser.shutdown();*/

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        pool.execute(MyThread::new);
        pool.execute(MyThread::new);
        pool.shutdown();//gracefully shutdown
    }

}

class MyThread implements Callable {

    @Override
    public  Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "====进入线程");
        return 123;
    }
}

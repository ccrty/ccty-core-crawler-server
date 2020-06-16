package com.ccty.noah.thread;

import java.util.concurrent.Callable;

/**
 * 多线程基类
 * @author 缄默
 * @date   2020/06/12
 * @param <V>
 */
public abstract class BaseCallable<V> implements Callable<V> {
    /**
     * 前置处理，子类可以Override该方法
     */
    public void beforeProcess() {
        System.out.println("before process....");
    }
    /**
     * 处理业务逻辑的方法,需要子类去Override
     * @return
     */
    public abstract V process();
    /**
     * 后置处理，子类可以Override该方法
     */
    public void afterProcess() {
        System.out.println("after process....");
    }
    @Override
    public V call() throws Exception {
        beforeProcess();
        V result = process();
        afterProcess();
        return result;
    }
}
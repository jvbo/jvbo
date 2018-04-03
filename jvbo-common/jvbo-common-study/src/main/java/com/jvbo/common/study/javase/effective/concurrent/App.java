/*
 * App.java 2018年3月13日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * java.util.concurrent包中主要分为三类:
 * 1. Executor Framework
 * 2. 并发集合(Concurrent Collection)
 * 3. 同步器(Synchronizer)
 * @ClassName: App 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月13日
 */
public class App {
    public static void main(String[] args) {
        
    }
    
    
    public static long time(Executor executor, int concurrency, 
            final Runnable action) throws InterruptedException{
        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(new Runnable(){

                @Override
                public void run() {
                    ready.countDown();// tell timer we are ready.
                    try {
                        start.await();// wait till peers are ready.
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        done.countDown();// tell timer we are done;
                    }
                    action.run();
                }
                
            });
        }
        ready.await();// wait for all workers to be ready.
        long startNanos = System.nanoTime();
        start.countDown();// and they are off.
        done.await();// wait for all workers to finish.
        return System.nanoTime() - startNanos;
    }
}

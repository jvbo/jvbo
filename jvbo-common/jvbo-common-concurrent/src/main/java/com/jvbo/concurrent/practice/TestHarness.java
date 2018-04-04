/*
 * TestHarness.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.concurrent.CountDownLatch;

/**
 * 在计时测试中使用CountDownLatch来启动和停止线程
 * @ClassName: TestHarness 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
public class TestHarness {
    /**
     * 启动门将使得主线程能够同时释放所有的工作线程,
     * 结束门则使主线程能够等待最后一个线程执行完成,而不是顺序地等待每个线程执行完成;
     */
    
    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);// 起始门 初始值1
        final CountDownLatch endGate = new CountDownLatch(nThreads);// 结束门 初始值为工作线程的(需要等待的)数量
        
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(){
                public void run(){
                    try {
                        startGate.await();// 等待计数器方法到达0,表示所有需要等待的事件都已经发生了
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();// 方法递减计数器,表示有一个事件已经发生了
                        }
                    } catch (InterruptedException e) { }

                }
            };
            t.start();
        }
        
        long start = System.nanoTime();
        startGate.countDown();// 方法递减计数器,表示有一个事件已经发生了
        endGate.await();// 等待计数器方法到达0,表示所有需要等待的事件都已经发生了
        long end = System.nanoTime();
        return end - start;
    }
    
    public static void main(String[] args) throws InterruptedException {
        int nThreads = 10;// 计数器,表示需要等待的事件数量;
        System.out.println(timeTasks(nThreads, new Runnable() {
            
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }));
    }
}

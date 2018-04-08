/*
 * Interrupt.java 2018年4月8日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.time;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 中断示例
 * @ClassName: Interrupt 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月8日
 */
public class Interrupt {
    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(1);
    
    /**
     * 在外部线程中安排中断(不要这么做)
     * @Description: TODO
     * @param @param r
     * @param @param timeout
     * @param @param unit   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年4月8日
     */
    /*public static void timedRun(Runnable r, long timeout, TimeUnit unit){
        final Thread taskThread = Thread.currentThread();
        cancelExec.schedule(new Runnable(){

            @Override
            public void run() {
                taskThread.interrupt();
            }
            
        }, timeout, unit);
        r.run();
    }*/
    
    /**
     * 在专门的线程中中断任务
     * @Description: TODO
     * @param @param r
     * @param @param timeout
     * @param @param unit   
     * @return void  
     * @throws InterruptedException 
     * @throws
     * @author jvbo
     * @date 2018年4月8日
     */
    /*public static void timedRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException{
        class RethrowableTask implements Runnable{
            private volatile Throwable t;

            @Override
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }
            
            void rethrow(){
                if(t != null){
                    throw launderThrowable(t);
                }
            }
        }
        
        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = Thread.currentThread();
        taskThread.start();
        cancelExec.schedule(new Runnable(){

            @Override
            public void run() {
                taskThread.interrupt();
            }
            
        }, timeout, unit);
        taskThread.join(unit.toMillis(timeout));
        task.rethrow();
    }*/
    
    /**
     * 通过Future来取消任务
     * @Description: TODO
     * @param @param r
     * @param @param timeout
     * @param @param unit
     * @param @throws InterruptedException   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年4月8日
     */
    public static void timedRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException{
        /**
         * 这里当Future.get抛出 #ExecutionException 或 #TimeoutException 时,
         * 如果知道不再需要结果,那么就可以调用Future.cancel来取消任务;
         */
        final ScheduledExecutorService taskExec = Executors.newScheduledThreadPool(1);
        Future<?> task = taskExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (ExecutionException e) {
            // 如果在任务中抛出了异常,那么重新抛出该异常
            throw launderThrowable(e.getCause());
        } catch (TimeoutException e) {
            // 接下来任务将被取消
        } finally {
            // 如果任务已经结束,那么执行取消操作也不会带来任何影响
            task.cancel(true);// 如果任务正在运行,那么将被中断
        }
    }

    public static RuntimeException launderThrowable(Throwable t) {
        // TODO Auto-generated method stub
        return null;
    }
}

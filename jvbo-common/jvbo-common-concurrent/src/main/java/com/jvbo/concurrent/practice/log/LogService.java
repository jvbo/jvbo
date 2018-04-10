/*
 * LogService.java 2018年4月10日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.log;

import java.io.Writer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 向LogWriter添加可靠的取消操作
 * @ClassName: LogService 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月10日
 */
public class LogService {
    /*private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;
    private PrintWriter writer; 
    @GuardedBy("this")
    private boolean isShutdown;
    @GuardedBy("this")
    private int reservations;
    
    public LogService(Writer writer){
        queue = new LinkedBlockingQueue<>(10);
        this.loggerThread = new LoggerThread(writer);
    }
    
    public void start(){
        loggerThread.start();
    }
    
    public void stop(){
        synchronized(this){
            isShutdown = true;
        }
        loggerThread.interrupt();
    }
    
    public void log(String msg) throws InterruptedException{
        synchronized(this){
            if(isShutdown)
                throw new IllegalStateException("");
            ++ reservations;
        }
        queue.put(msg);
    }
    
    private class LoggerThread extends Thread{
        private final PrintWriter writer; 

        public LoggerThread(Writer writer) {
            this.writer = (PrintWriter) writer;
        }

        public void run(){
            try {
                while(true){
                    try {
                        synchronized(LogService.this){
                            if(isShutdown && reservations ==0)
                                break;
                        }
                        String msg = queue.take();
                        synchronized(LogService.this){
                            --reservations;
                        }
                        writer.println(msg);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } finally {
                writer.close();
            }
        }
    }*/
    
    
    
    
    
    
    
    
    
    private final ExecutorService exec = newSingleThreadExecutor();

    private static ExecutorService newSingleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }
    
    /**
     * 通过注册一个关闭钩子来停止日志服务
     * @Description: TODO
     * @param    
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年4月10日
     */
    public void start(){
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                try {
                    LogService.this.stop();
                } catch (InterruptedException ignored) {
                    // ignore
                }
            }
        });
    }
    
    public void stop() throws InterruptedException{
        try {
            exec.shutdown();
            exec.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } finally {
            // writer.close();
        }
    }
    
    public void log(String msg){
        try {
            exec.execute(new WriterTask(msg));
        } catch (RejectedExecutionException ignored) {
            
        }
    }
    
    private class WriterTask implements Runnable{

        public WriterTask(String msg) {
            // TODO Auto-generated constructor stub
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            
        }
        
    }
}

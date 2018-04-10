/*
 * LogWriter.java 2018年4月10日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.log;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 不支持关闭的生产者-消费者日志服务
 * @ClassName: LogWriter 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月10日
 */
public class LogWriter {
    private final BlockingQueue<String> queue;
    private final LoggerThread logger;
    private boolean shutdownRequested;

    public LogWriter(Writer writer){
        queue = new LinkedBlockingQueue<>(10);
        this.logger = new LoggerThread(writer);
    }

    public void start(){
        logger.start();
    }

    public void log(String msg) throws InterruptedException{
        if(!shutdownRequested)
            queue.put(msg);
        else
            throw new IllegalStateException("logger is shut down");
    }

    private class LoggerThread extends Thread{
        private final PrintWriter writer; 

        public LoggerThread(Writer writer) {
            this.writer = (PrintWriter) writer;
        }

        public void run(){
            try {
                while(true)
                    writer.println(queue.take());
            } catch (InterruptedException e) {
                
            } finally {
                writer.close();
            }
        }
    }
}

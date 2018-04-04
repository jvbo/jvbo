/*
 * Indexer.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * 桌面搜索应用程序中的消费者任务
 * @ClassName: Indexer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
public class Indexer implements Runnable {
    private final BlockingQueue<File> queue;
    
    public Indexer(BlockingQueue<File> queue){
        this.queue = queue;
    }
    
    @Override
    public void run() {
        try {
            while(true)
                indexFile(queue.take());
        } catch (InterruptedException e) {
            // 恢复中断,已避免屏蔽中断
            Thread.currentThread().interrupt();
        }
    }

    private void indexFile(File take) {
        // TODO Auto-generated method stub
        
    }

}

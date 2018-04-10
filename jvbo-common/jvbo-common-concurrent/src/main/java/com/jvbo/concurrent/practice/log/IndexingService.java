/*
 * IndexingService.java 2018年4月10日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.log;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * 通过毒丸对象来关闭服务
 * @ClassName: IndexingService 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月10日
 */
public class IndexingService {
    private static final File POISON = new File("");
    private final IndexingThread consumer = new IndexingThread();
    private final CrawerThread producer = new CrawerThread();
    private final BlockingQueue<File> queue;
    private final FileFilter fileFilter;
    private final File root;

    
    
    public IndexingService(BlockingQueue<File> queue, FileFilter fileFilter, File root) {
        this.queue = queue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    class IndexingThread extends Thread{
        public void run(){
            try {
                crawl(root);
            } catch (InterruptedException e) {
                // TODO 异常
            } finally {
                while(true){
                    try {
                        queue.take();
                        break;
                    } catch (InterruptedException e) {
                        // TODO 重新尝试
                    }
                }
            }
        }
    }
    class CrawerThread extends Thread{
        public void run(){
            while(true){
                try {
                    File file = queue.take();
                    if(file == POISON)
                        break;
                    else
                        indexFile(file);
                } catch (InterruptedException e) {
                    // TODO 
                }
            }
        }
    }
    
    public void start(){
        producer.start();
        consumer.start();
    }
    
    public void indexFile(File file) {
        // TODO Auto-generated method stub
        
    }

    public void crawl(File root) throws InterruptedException {
        // TODO Auto-generated method stub
        
    }

    public void stop(){
        producer.interrupt();
    }
    
    public void awaitTermination() throws InterruptedException{
        consumer.join();
    }
}

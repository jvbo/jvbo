/*
 * FileCrawer.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 煮面搜索应用程序中的生产者任务
 * @ClassName: FileCrawer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
public class FileCrawer implements Runnable {
    private final BlockingQueue<File> fileQueue;
    private final FileFilter fileFilter;
    private final File root;
    
    public FileCrawer(BlockingQueue<File> fileQueue, FileFilter fileFilter,
            File root){
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    @Override
    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            // 恢复中断,已避免屏蔽中断
            Thread.currentThread().interrupt();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] entreies = root.listFiles(fileFilter);
        if(entreies != null){
            for (File file : entreies) {
                if(file.isDirectory())
                    crawl(file);
                else if(!alreadyIndexed(file))
                    fileQueue.put(file);
            }
        }
    }

    private boolean alreadyIndexed(File file) {
        // TODO Auto-generated method stub
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void startIndexing(File[] roots){
        BlockingQueue<File> queue = new LinkedBlockingQueue<>(10);
        FileFilter filter = new FileFilter(){
            public boolean accept(File file){return true;}
        };
        
        for (File root : roots)
            new Thread(new FileCrawer(queue, filter, root)).start();
        
        for (int i = 0; i < 10; i++) {
            new Thread(new Indexer(queue)).start();;
        }
    }

}

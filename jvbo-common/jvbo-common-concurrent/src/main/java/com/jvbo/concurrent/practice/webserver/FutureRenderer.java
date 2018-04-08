/*
 * FutureRenderer.java 2018年4月8日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.webserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用 #Future 等待图像下载
 * @ClassName: FutureRenderer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月8日
 */
public class FutureRenderer {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    
    void renderPage(CharSequence source) {
        final List<ImageInfo> imageInfos = scanForImageInfo(source);
        Callable<List<ImageData>> task = new Callable<List<ImageData>>(){

            @Override
            public List<ImageData> call() throws Exception {
                List<ImageData> result = new ArrayList<>();
                for (ImageInfo imageInfo : imageInfos) {
                    result.add(imageInfo.downloadImage());
                }
                return null;
            }
            
        };
        
        // 先执行着下载图像
        Future<List<ImageData>> future = executor.submit(task);
        // 同时渲染文本
        renderText(source);
        
        try {
            List<ImageData> imageData = future.get();
            for (ImageData data : imageData) {
                renderImage(data);
            }
        } catch (InterruptedException e) {
            // 重新设置线程的中断状态
            Thread.currentThread().interrupt();
            // 由于不需要结果,因此取消任务
            future.cancel(true);
        } catch (ExecutionException e){
            throw launderThrowable(e.getCause());
        }
    }

    private RuntimeException launderThrowable(Throwable cause) {
        // TODO Auto-generated method stub
        return null;
    }

    private void renderImage(ImageData data) {
        // TODO Auto-generated method stub
        
    }

    private void renderText(CharSequence source) {
        // TODO Auto-generated method stub
        
    }

    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        // TODO Auto-generated method stub
        return null;
    }
}

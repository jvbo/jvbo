/*
 * Renderer.java 2018年4月8日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.webserver;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 使用CompletionService使页面元素在下载完成后立即显示出来
 * @ClassName: Renderer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月8日
 */
public class Renderer {
    private final ExecutorService executor;
    
    private static final int TIME_BUDGET = 60000000;
    
    private static final Ad DEFAULT_AD = new Ad();

    Renderer(ExecutorService executor){
        this.executor = executor;
    }

    void renderPage(CharSequence source){
        List<ImageInfo> info = scanForImageInfo(source);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<ImageData>(executor);
        for (final ImageInfo imageInfo : info) {
            completionService.submit(new Callable<ImageData>(){

                @Override
                public ImageData call() throws Exception {
                    return imageInfo.downloadImage();
                }

            });
        }

        renderText(source);

        try {
            for (int i = 0; i < info.size(); i++) {
                Future<ImageData> f = completionService.take();
                ImageData imageData = f.get();
                renderImage(imageData);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e){
            throw launderThrowable(e.getCause());
        }
    }
    
    Page renderPageWithAd(){
        long endNanos = System.nanoTime() + TIME_BUDGET;
        Future<Ad> f = executor.submit(new FetchAdTask());
        // 等待广告的同时显示页面
        Page page = renderPageBody();
        Ad ad = null;
        //只等待指定的时间长度
        long timeLeft = endNanos - System.nanoTime();
        try {
            ad = f.get(timeLeft, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            ad = DEFAULT_AD;
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            ad = DEFAULT_AD;
        } catch (TimeoutException e) {
            ad = DEFAULT_AD;
            f.cancel(true);
        }
        page.setAd(ad);
        return page;
    }

    private Page renderPageBody() {
        // TODO Auto-generated method stub
        return null;
    }

    private RuntimeException launderThrowable(Throwable cause) {
        // TODO Auto-generated method stub
        return null;
    }

    private void renderImage(ImageData imageData) {
        // TODO Auto-generated method stub
        
    }

    private void renderText(CharSequence source) {
        // TODO Auto-generated method stub

    }

    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        // TODO Auto-generated method stub
        return null;
    }

    
    static class FetchAdTask implements Callable<Ad>{

        @Override
        public Ad call() throws Exception {
            // TODO Auto-generated method stub
            return null;
        }
        
    }
    
}

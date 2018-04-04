/*
 * Preloader.java 2018年4月5日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用FutureTask来提前加载稍后需要的数据
 * @ClassName: Preloader 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月5日
 */
public class Preloader {
    
    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(
            new Callable<ProductInfo>(){

                @Override
                public ProductInfo call() throws Exception {
                    return loadProductInfo();
                }
            });
    
    private final Thread thread = new Thread(future);
    
    public void start(){
        thread.start();
    }
    
    public ProductInfo get() throws InterruptedException, DataLoadException{
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if(cause instanceof DataLoadException)
                throw (DataLoadException)cause;
            else
                throw launderThrowable(cause);
        }
    }
    
    /**
     * 这里强制将未检查的Throwable转换为RuntimeException
     * 如果 #Throwable 是 #Error ,那么抛出它,如果是 #RuntimeException,那么返回它,
     * 否则抛出 #IllegalStateException
     * @Description: TODO
     * @param @param cause
     * @param @return   
     * @return RuntimeException  
     * @throws
     * @author jvbo
     * @date 2018年4月5日
     */
    private static RuntimeException launderThrowable(Throwable cause) {
        if(cause instanceof RuntimeException)
            return (RuntimeException)cause;
        else if(cause instanceof Error)
            throw (Error)cause;
        else
            throw new IllegalStateException("not unchecked", cause);
    }
    protected ProductInfo loadProductInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    private static class ProductInfo{}

}

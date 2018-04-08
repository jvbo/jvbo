/*
 * CancellingExecutor.java 2018年4月8日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.interrupt;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CancellingExecutor<T> extends ThreadPoolExecutor {

    public CancellingExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        // TODO Auto-generated constructor stub
    }
    
    protected<T> RunnableFuture<T> newTaskFor(Callable<T> callable){
        if(callable instanceof CancellableTask)
            return ((CancellableTask<T>)callable).newTask();
        else
            return super.newTaskFor(callable);
    }

}

/*
 * CancellableTask.java 2018年4月8日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.interrupt;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * 通过newTaskFor将非标准的取消操作封装在一个任务中
 * @ClassName: CancellableTask 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月8日
 */
public interface CancellableTask<T> extends Callable<T>  {
    void cancel();
    RunnableFuture<T> newTask();
}

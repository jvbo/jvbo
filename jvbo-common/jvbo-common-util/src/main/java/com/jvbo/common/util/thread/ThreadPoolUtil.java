/*
 * @(#) initServlet.java 2015年9月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.util.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil {

	private final ExecutorService executor;
	private final ScheduledExecutorService scheduleExecutor;

	private static volatile ThreadPoolUtil instance = null;

	private ThreadPoolUtil() {
		this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
		this.scheduleExecutor = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
	}

	public static ThreadPoolUtil getInstance() {
		if(instance == null){
			synchronized (ThreadPoolUtil.class){
				if(instance == null){
					instance = new ThreadPoolUtil();
				}
			}
		}
		return instance;
	}

	public static <T> Future<T> execute(final Callable<T> runnable) {
		return getInstance().executor.submit(runnable);
	}

	public static Future<?> execute(final Runnable runnable) {
		return getInstance().executor.submit(runnable);
	}
	
	public static ScheduledFuture<?> scheduleWithFixedDelay(final Runnable runnable, final int initDelay, final int delay){
		return getInstance().scheduleExecutor.scheduleWithFixedDelay(runnable, initDelay, delay, TimeUnit.SECONDS);
	}

}

package com.jvbo.common.study.javaee.netty.bio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/26
 */
public class TimeServerHandlerExecutePool  {

	private ExecutorService excutorService;

	public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
		excutorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
				maxPoolSize,
				120L,
				TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(queueSize));
	}

	public void execute(Runnable task) {
		excutorService.execute(task);
	}
}

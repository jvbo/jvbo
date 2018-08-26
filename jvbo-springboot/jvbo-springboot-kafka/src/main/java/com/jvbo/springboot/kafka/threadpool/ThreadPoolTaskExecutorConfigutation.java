package com.jvbo.springboot.kafka.threadpool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/21
 */
@Configuration
@ConfigurationProperties(prefix = "threadpool")
public class ThreadPoolTaskExecutorConfigutation {

	@Value("${threadpool.core-pool-size}")
	private int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;

	@Value("${threadpool.max-pool-size}")
	private int maxPoolSize = Runtime.getRuntime().availableProcessors() * 4;

	@Value("${threadpool.queue-capacity}")
	private int queueCapacity = 300;

	@Value("${threadpool.keep-alive-seconds}")
	private int keepAliveSeconds = 60;


	@Bean(name = "threadPoolTaskExecutor")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
	    System.out.println("corePoolSize: " + corePoolSize);
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setThreadNamePrefix("lianma-crawler-consumer-threadpool-");
		pool.setKeepAliveSeconds(keepAliveSeconds);
		pool.setCorePoolSize(corePoolSize);
		pool.setMaxPoolSize(maxPoolSize);
		pool.setQueueCapacity(queueCapacity);
		pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return pool;
	}
}

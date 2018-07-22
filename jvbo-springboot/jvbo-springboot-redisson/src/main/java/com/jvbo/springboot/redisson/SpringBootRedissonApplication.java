package com.jvbo.springboot.redisson;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.jvbo.springboot.redisson.lock.RedissLockUtil;

@SpringBootApplication
public class SpringBootRedissonApplication implements CommandLineRunner {
	
    private int countNoLock = 0;
    private int countLock = 0;
    private static final int LENGTH = 1000;
    
	public static void main(String[] args) {
	    SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootRedissonApplication.class).web(WebApplicationType.NONE);
	    builder.run(args);
	}

    @Override
    public void run(String... args) throws Exception {
        testNoLock();
        testLock();
    }
    
    private void testNoLock() throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch threadLatch = new CountDownLatch(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    countNoLock += 1;
                    threadLatch.countDown();
                }
            };
            executorService.submit(runnable);
        }
        threadLatch.await();
        System.out.println(countNoLock);
    }
    
    private void testLock() throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch threadLatch = new CountDownLatch(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    RedissLockUtil.lock("testLock.redis.lock", TimeUnit.SECONDS, 1);
                    countLock += 1;
                    RedissLockUtil.unlock("testLock.redis.lock");
                    threadLatch.countDown();
                }
            };
            executorService.submit(runnable);
        }
        threadLatch.await();
        System.out.println(countLock);
    }
}

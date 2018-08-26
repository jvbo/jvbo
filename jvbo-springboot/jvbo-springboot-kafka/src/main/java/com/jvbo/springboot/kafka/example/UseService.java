/*
 * UseService.java 2018年8月21日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.kafka.example;

import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class UseService {
    
    /*private ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    */
    final CountDownLatch coutDownLatch = new CountDownLatch(10);
    
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    
    public void use(){
        for (int i = 0; i < 10000; i++) {
            final int a = i;
            threadPoolTaskExecutor.execute(new Runnable() {
                
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    us(a);
                    coutDownLatch.countDown();
                }
            });
            /*executor.execute(new Runnable() {
                
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    us(a);
                    coutDownLatch.countDown();
                }
            });*/
        }
    }
    
    private void us(int i){
        System.out.println("i:" + i + "now:" + Instant.now().toEpochMilli());
    }
}

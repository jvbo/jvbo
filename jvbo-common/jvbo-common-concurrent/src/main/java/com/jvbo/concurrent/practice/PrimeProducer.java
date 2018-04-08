/*
 * PrimeProducer.java 2018年4月8日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 通过终端来取消
 * @ClassName: PrimeProducer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月8日
 */
public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    
    PrimeProducer(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }
    
    public void run(){
        try {
            BigInteger p = BigInteger.ONE;
            if(!Thread.currentThread().isInterrupted())
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException e) { 
            // 允许线程退出
        }
    }
    
    public void cancel(){
        interrupt();
    }
}

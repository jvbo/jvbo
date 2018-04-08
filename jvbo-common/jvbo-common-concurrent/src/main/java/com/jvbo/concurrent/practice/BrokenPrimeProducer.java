/*
 * BrokenPrimeProducer.java 2018年4月8日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 不可靠的取消操作将把生产者置于阻塞的操作中(不要这么做)
 * @ClassName: BrokenPrimeProducer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月8日
 */
public class BrokenPrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    BrokenPrimeProducer(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    public void run(){
        try {
            BigInteger p = BigInteger.ONE;
            while(!cancelled){
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) { }
    }
    
    public void cancel(){
        cancelled = true;
    }
    
    void consumePrimes() throws InterruptedException {
        BlockingQueue<BigInteger> primes = new LinkedBlockingQueue<>(10);
        BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
        producer.start();
        try {
            while (needMorePrimes()) {
                consume(primes.take());
            } 
        } finally {
            producer.cancel();
        }
    }
    
    
    

    private boolean needMorePrimes() {
        // TODO Auto-generated method stub
        return false;
    }

    private void consume(BigInteger take) {
        // TODO Auto-generated method stub
        
    }
}

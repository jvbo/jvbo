/*
 * PrimeGenerator.java 2018年4月8日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.jvbo.concurrent.practice.annotation.GuardedBy;
import com.jvbo.concurrent.practice.annotation.ThreadSafe;

/**
 * 使用volatile类型的域来保存取消状态
 * @ClassName: PrimeGenerator 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月8日
 */
@ThreadSafe
public class PrimeGenerator implements Runnable {
    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<>();
    
    private volatile boolean cancelled;// 必须volatile

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while(!cancelled){
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }
    
    public void cancel(){
        cancelled = true;
    }
    
    public synchronized List<BigInteger> get(){
        return new ArrayList<>(primes);
    }
    
    public static void main(String[] args) throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        List<BigInteger> results = generator.get();
        System.out.println(Arrays.toString(results.toArray()));
    }
    
}

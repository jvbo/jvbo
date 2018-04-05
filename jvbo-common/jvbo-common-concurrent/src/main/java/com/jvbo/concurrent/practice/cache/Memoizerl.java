/*
 * Memoizerl.java 2018年4月5日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.cache;

import java.util.HashMap;
import java.util.Map;

import com.jvbo.concurrent.practice.annotation.GuardedBy;

/**
 * 使用HashMap和同步机制来初始化缓存
 * @ClassName: Memoizerl 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月5日
 */
public class Memoizerl<A, V> implements Computable<A, V> {
    /**
     * 问题:采用了一种保守的方法,即对整个compute方法进行同步,这种方法能确保线程安全性,
     * 但会带来一个明显的可伸缩性问题:每次只有一个线程能够执行compute,如果另一个线程正在计算结果,
     * 那么其他调用compute的线程可能被阻塞很长时间;
     */
    
    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> c;
    
    public Memoizerl(Computable<A, V> c){
        this.c = c;
    }
    

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if(result == null){
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }

}

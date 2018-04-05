/*
 * Memoizerl2.java 2018年4月5日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.jvbo.concurrent.practice.annotation.GuardedBy;

/**
 * 使用ConcurrentHashMap替换HashMap
 * @ClassName: Memoizerl2 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月5日
 */
public class Memoizerl2<A, V> implements Computable<A, V> {
    /**
     * 问题:在作为缓存时仍然有些不足,当两个线程同时调用compute时存在一个漏洞,
     * 可能会导致计算得到相同的值;如果某个线程启动了一个开销很大的计算,而其他线程
     * 并不知道这个计算正在进行,那么很可能会重复这个计算;
     */
    
    @GuardedBy("this")
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;
    
    public Memoizerl2(Computable<A, V> c){
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if(result == null){
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}

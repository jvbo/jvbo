/*
 * Memoizerl3.java 2018年4月5日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.cache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.jvbo.concurrent.practice.annotation.GuardedBy;

/**
 * 基于FutureTask的Memoizing封装器
 * @ClassName: Memoizerl3 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月5日
 */
public class Memoizerl3<A, V> implements Computable<A, V> {
    /**
     * 首先检查某个相应的计算是否已经开始;如果还没启动,那么就创建一个FutureTask,并注册到Map中,
     * 然后启动计算:如果已经启动,那么等待现有计算结果;
     * 
     * 问题:仍然存在两个线程计算出相同值的漏洞;由于compute方法中if代码块仍然是非原子的先检查再执行操作,
     * 因此两个线程仍有可能同一时间内调用compute来计算相同的值,即二者都没有在缓存中找到期望的值,
     * 因此都开始计算;
     */
    
    @GuardedBy("this")
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;
    
    public Memoizerl3(Computable<A, V> c){
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if(f == null){
            Callable<V> eval = new Callable<V>(){

                @Override
                public V call() throws InterruptedException {
                    return c.compute(arg);
                }
                
            };
            
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run();// 这里将调用c.copute
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw launderThrowable(e.getCause());
        }
    }

    private RuntimeException launderThrowable(Throwable cause) {
        // TODO Auto-generated method stub
        return null;
    }
}


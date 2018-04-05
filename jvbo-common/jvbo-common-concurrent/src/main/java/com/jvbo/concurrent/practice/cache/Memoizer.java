/*
 * Memoizer.java 2018年4月5日
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
 * Memoizer的最终实现
 * @ClassName: Memoizer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月5日
 */
public class Memoizer<A, V> implements Computable<A, V> {
    
    @GuardedBy("this")
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;
    
    public Memoizer(Computable<A, V> c){
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        while(true){
            Future<V> f = cache.get(arg);
            if(f == null){
                Callable<V> eval = new Callable<V>(){

                    @Override
                    public V call() throws InterruptedException {
                        return c.compute(arg);
                    }
                    
                };
                
                FutureTask<V> ft = new FutureTask<V>(eval);
                f = cache.putIfAbsent(arg, ft);
                if(f == null){
                    f = ft;
                    ft.run();// 这里将调用c.copute
                }
            }
            try {
                return f.get();
            } catch (ExecutionException e) {
                throw launderThrowable(e.getCause());
            }
        }
    }

    private RuntimeException launderThrowable(Throwable cause) {
        // TODO Auto-generated method stub
        return null;
    }
}



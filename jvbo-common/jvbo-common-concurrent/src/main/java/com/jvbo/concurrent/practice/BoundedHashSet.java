/*
 * BoundedHashSet.java 2018年4月5日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 使用Semaphore为容器设置边界
 * @ClassName: BoundedHashSet 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月5日
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;
    
    public BoundedHashSet(int bound){
        this.set = Collections.synchronizedSet(new HashSet<>());
        sem = new Semaphore(bound);
    }
    
    public boolean add(T o) throws InterruptedException{
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if(!wasAdded)
                sem.release();
        }
    }
    
    public boolean remove(Object o){
        boolean wasRemoved = set.remove(o);
        if(wasRemoved)
            sem.release();
        return wasRemoved;
    }
}

/*
 * ImprovedList.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.jvbo.concurrent.practice.annotation.ThreadSafe;

/**
 * 通过组合实现"若没有则添加"
 * @ClassName: ImprovedList 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
@ThreadSafe
public abstract class ImprovedList<T> implements List<T> {
    /**
     * ImprovedList通过自身的内置锁增加了一层额外的加锁;
     * 它并不关心底层的List是否是线程安全的,即使List不是线程安全的或者修改了它的加锁实现,
     * ImprovedList也会提供一致的加锁机制来实现线程安全性;
     * 虽然额外的同步层可能导致轻微的性能损失,但与模拟另一个对象的加锁策略相比,
     * ImprovedList更为健壮;事实上,我们使用了java监视器模式来封装现有的List,
     * 并且只要在类中拥有指向底层List的唯一外部引用,就能确保线程安全性;
     */
    
    private final List<T> list;
    
    public ImprovedList(List<T> list){
        this.list = list;
    }
    
    public synchronized boolean putIfAbsent(T x){
        boolean contains = list.contains(x);
        if(contains)
            list.add(x);
        return !contains;
    }
    
    // ... 按照类似的方式委托List的其他方法;
}

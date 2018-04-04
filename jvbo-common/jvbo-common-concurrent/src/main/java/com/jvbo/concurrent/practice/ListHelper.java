/*
 * ListHelper.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jvbo.concurrent.practice.annotation.ThreadSafe;

/**
 * 非线程安全的"若没有则添加"(不要这么做)
 * @ClassName: ListHelper 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
/*@NotThreadSafe
public class ListHelper<E> {
    *//**
     * 解释:这里在错误的锁上进行了同步,无论List使用哪一个锁来保护它的状态,
     *     可以确定的是,这个锁并不是ListHelper上的锁;ListHelper只是带来了同步的假象,
     *     尽管所有的链表操作都被声明为synchronized,但却使用了不同的锁,这意味着putIfAbsent
     *     相对于List的其他操作来说并不是原子的,因此就无法确保当putIfAbsent执行时
     *     另一个线程不会修改链表;
     *//*
    
    public List<E> list = Collections.synchronizedList(new ArrayList<>());
    
    public synchronized boolean putIfAbsent(E x){
        boolean absent = !list.contains(x);
        if(!absent)
            list.add(x);
        return absent;
    }

}*/

/**
 * 通过客户端加锁来实现"若没有则添加"
 * @ClassName: ListHelper 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
@ThreadSafe
public class ListHelper<E> {
    
    public List<E> list = Collections.synchronizedList(new ArrayList<>());
    
    public boolean putIfAbsent(E x){
        synchronized (list){
            boolean absent = !list.contains(x);
            if(!absent)
                list.add(x);
            return absent;
        }
    }

}

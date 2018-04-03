/*
 * UnsafeSequence.java 2018年4月1日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import com.jvbo.concurrent.practice.annotation.GuardedBy;
import com.jvbo.concurrent.practice.annotation.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
    /**
     * 常见并发安全性问题:竞态条件
     */
    
    /*private int value;
    
    public int getNext(){
        return value++;
    }*/
    
    @GuardedBy("this")
    private int value;
    
    public synchronized int getNext(){
        return value++;
    }
}

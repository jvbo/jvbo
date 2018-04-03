/*
 * SynchronizedInteger.java 2018年4月2日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import com.jvbo.concurrent.practice.annotation.GuardedBy;
import com.jvbo.concurrent.practice.annotation.ThreadSafe;

/**
 * 线程安全的可变整数类
 * @ClassName: SynchronizedInteger 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月2日
 */
@ThreadSafe
public class SynchronizedInteger {
    @GuardedBy("this")
    private int value;

    public synchronized int get(){return value;}
    public synchronized void set(int value){this.value = value;}
}

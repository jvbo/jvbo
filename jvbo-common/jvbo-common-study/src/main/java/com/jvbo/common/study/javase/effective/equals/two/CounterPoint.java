/*
 * CounterPoint.java 2018年1月30日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.equals.two;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterPoint extends Point {
    
    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }
    
    public int numberCreated() {
        return counter.get();
    }

}

/*
 * VolatileUse.java 2018年3月13日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.thread;

import java.util.concurrent.atomic.AtomicLong;

public class VolatileUse {
    
    public static void main(String[] args) {
        System.out.println(generateSerialNumber());
    }
    
    /*private static volatile int nextSerialNumber = 0;
    public static int generateSerialNumber(){
        return nextSerialNumber ++;
    }*/
    
    private static final AtomicLong nextSerialNumber = new AtomicLong();
    public static long generateSerialNumber(){
        return nextSerialNumber.getAndIncrement();
    }
}

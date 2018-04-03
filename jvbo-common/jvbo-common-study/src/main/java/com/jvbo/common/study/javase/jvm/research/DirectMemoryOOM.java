/*
 * DirectMemoryOOM.java 2018年1月12日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 本机直接内存溢出
 * @ClassName: DirectMemoryOOM 
 * @Description: vm args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * @author jvbo
 * @date 2018年1月12日
 */
public class DirectMemoryOOM {
    
    private static final long _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
    }

}

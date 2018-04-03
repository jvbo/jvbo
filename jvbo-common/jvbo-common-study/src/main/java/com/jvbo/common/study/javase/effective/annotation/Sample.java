/*
 * Sample.java 2018年2月11日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.annotation;

public class Sample {
    @Test
    @ExceptionTest({ArithmeticException.class, NullPointerException.class})
    public static void m1(){
        int i = 0;
        i = i / 1;
    }
    
    @Test
    @ExceptionTest(ArithmeticException.class)
    public static void m2(){
        int [] a = new int[0];
        int i = a[1];
    }
    
    @Test
    @ExceptionTest(ArithmeticException.class)
    public static void m3(){
        throw new RuntimeException("Boom");
    }
    
    public static void m4(){}
    
    public void m5(){}
    
    public static void m6(){}
    
    @Test
    public static void m7(){
        throw new RuntimeException("Crash");
    }
    
    public static void m8(){}
}

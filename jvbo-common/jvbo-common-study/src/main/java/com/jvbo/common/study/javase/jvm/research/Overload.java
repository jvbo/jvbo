/*
 * Overload.java 2018年3月15日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.io.Serializable;

public class Overload {
    
    public static void sayHello(Object arg){
        System.out.println("hello Object");
    }
    
    public static void sayHello(int arg){
        System.out.println("hello int");
    }
    
    public static void sayHello(long arg){
        System.out.println("hello long");
    }
    
    public static void sayHello(Character arg){
        System.out.println("hello Character");
    }
    
    public static void sayHello(char arg){
        System.out.println("hello char");
    }
    
    public static void sayHello(char... arg){
        System.out.println("hello char...");
    }
    
    public static void sayHello(Serializable arg){
        System.out.println("hello Serializable");
    }
    
    public static void main(String[] args) {
        sayHello('a');
    }

}

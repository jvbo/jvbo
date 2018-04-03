/*
 * Singleton.java 2018年1月29日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.singleton;

public class Singleton {
    
    public static final Singleton INSTANCE = new Singleton();
    
    private Singleton(){
        if(INSTANCE != null){
            System.out.println("阻止反射调用");
        }else{
            // 私有构造函数,但是可以通过反射调用
            System.out.println("INSTANCE内存地址:" + System.identityHashCode(INSTANCE));
            System.out.println("调用无参私有构造函数");
        }
    }
    
    public static Singleton getInstance(){
        return INSTANCE;
    }
    
    public void use(){
        System.out.println("singleton use");
    }
}

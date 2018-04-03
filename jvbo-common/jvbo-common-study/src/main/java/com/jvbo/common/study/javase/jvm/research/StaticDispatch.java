/*
 * StaticDispatch.java 2018年3月15日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * 方法静态分派
 * @ClassName: StaticDispatch 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月15日
 */
public class StaticDispatch {
    
    static abstract class Human{
        
    }
    
    static class Man extends Human{
        
    }
    
    static class Woman extends Human{
        
    }
    
    public void sayHello(Human guy){
        System.out.println("hello, gay!");
    }
    
    public void sayHello(Man guy){
        System.out.println("hello gentleman!");
    }
    
    public void sayHello(Woman guy){
        System.out.println("hellot lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }

}
/**
 * 1. javac -encoding UTF-8 StaticDispatch.java
 * 2. 
 */

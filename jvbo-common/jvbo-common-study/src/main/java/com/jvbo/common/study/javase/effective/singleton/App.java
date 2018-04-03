/*
 * App.java 2018年1月29日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.singleton;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;

/**
 * 反模式例子:使用反射破坏单例
 * AccessibleObject.setAccessible(constructors, true);
 * @ClassName: App 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月29日
 */
public class App {
    public static void main(String[] args) throws Exception {
        /*Singleton singleton = Singleton.getInstance();
        Constructor<?>[] constructors = singleton.getClass().getDeclaredConstructors(); 
        AccessibleObject.setAccessible(constructors, true);
        for (Constructor<?> constructor : constructors) {
            constructor.newInstance();
        }*/
        
        Thread thread1 = new Thread(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Singleton singleton = Singleton.getInstance();
            }
            
        });
        thread1.start();
        
        Thread thread2 = new Thread(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Singleton singleton = Singleton.getInstance();
            }
            
        });
        thread2.start();
    }
    
    public static void call() throws Exception{
        System.out.println("1");
        Class cl = Class.forName("com.jvbo.common.study.javase.effective.singleton.Singleton");
        Constructor constructor = cl.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }
}

/*
 * DynamicProxyApp.java 2018年3月17日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @ClassName: DynamicProxyApp 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月17日
 */
public class DynamicProxyApp {
    
    interface IHello{
        void sayHello();
    }
    
    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("hello world!");
        }
        
    }
    
    static class DynamicProxy implements InvocationHandler {
        
        Object originalObj;
        
        Object bind(Object originalObj){
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),
                    originalObj.getClass().getInterfaces(), 
                    this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originalObj, args);
        }
        
    }
    
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFields", true);
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
    }

}

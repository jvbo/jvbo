/*
 * JavaMethodAreaOOM.java 2018年1月12日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * 借助CGLIB使方法区出现内存溢出异常
 * @ClassName: JavaMethodAreaOOM 
 * @Description: vm args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author jvbo
 * @date 2018年1月12日
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while(true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor(){

                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invoke(obj, args);
                }

            });
            enhancer.create();
        }
    }
    
    static class OOMObject{
        
    }

}

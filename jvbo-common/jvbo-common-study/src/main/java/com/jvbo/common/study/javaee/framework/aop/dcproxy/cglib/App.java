/*
 * App.java 2018年5月25日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javaee.framework.aop.dcproxy.cglib;

import java.lang.reflect.Method;

import com.jvbo.common.study.javaee.framework.aop.dcproxy.Business;
import com.jvbo.common.study.javaee.framework.aop.dcproxy.IBusiness2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib实现
 * @ClassName: App 
 * @Description: TODO
 * @author jvbo
 * @date 2018年5月25日
 */
public class App {
    public static void main(String[] args) {
        byteCode();
    }

    private static void byteCode() {
        // 创建一个织入器
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(Business.class);
        // 设置需要织入的逻辑
        enhancer.setCallback(new LogIntercept());
        // 使用织入器创建子类
        IBusiness2 newBusiness = (IBusiness2)enhancer.create();
        newBusiness.doThing2();
    }
    
    public static class LogIntercept implements MethodInterceptor {

        @Override
        public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            // 执行原有逻辑
            Object obj = methodProxy.invokeSuper(target, args);
            // 执行织入的日志
            if(method.getName().equals("doThing2"))
                System.out.println("记录日志");
            return obj;
        }
        
    }
}

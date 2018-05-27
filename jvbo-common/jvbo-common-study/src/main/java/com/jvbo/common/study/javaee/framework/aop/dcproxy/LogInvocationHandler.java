/*
 * LogInvocationHandler.java 2018年5月25日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javaee.framework.aop.dcproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 打印日志的切面
 * @ClassName: LogInvocationHandler 
 * @Description: TODO
 * @author jvbo
 * @date 2018年5月25日
 */
public class LogInvocationHandler implements InvocationHandler {
    
    private Object target;// 目标对象

    public LogInvocationHandler(Business business) {
        this.target = business;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 执行原有逻辑
        Object obj = method.invoke(target, args);
        // 执行织入的日志,可以控制哪些方法执行切入逻辑
        if(method.getName().equals("doThing"))
            System.out.println("记录日志");
        return obj;
    }

}

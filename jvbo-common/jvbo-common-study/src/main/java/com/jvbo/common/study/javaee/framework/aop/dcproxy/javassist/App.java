/*
 * App.java 2018年5月25日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javaee.framework.aop.dcproxy.javassist;

import javassist.ClassPool;
import javassist.Loader;

public class App {
    public static void main(String[] args) throws Throwable {
        // 获取存放CtClass的容器ClassPool
        ClassPool cp = ClassPool.getDefault();
        // 创建一个类加载器
        Loader cl = new Loader();
        // 增加一个转换器
        cl.addTranslator(cp, new SampleTranslator());
        // 启动DemoTranslator的main函数
        cl.run("com.jvbo.common.study.javaee.framework.aop.dcproxy.javassist.SampleTranslator", args);
    }
    
}

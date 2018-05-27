/*
 * SampleTranslator.java 2018年5月25日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javaee.framework.aop.dcproxy.javassist;

import com.jvbo.common.study.javaee.framework.aop.dcproxy.Business;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.Translator;

public class SampleTranslator implements Translator {
    
    // TODO 类装载到jvm前进行代码织入
    @Override
    public void onLoad(ClassPool pool, String className) throws NotFoundException, CannotCompileException {
        if(!"com.jvbo.common.study.javaee.framework.aop.dcproxy.Business".equals(className))
            return;
        // 通过获取类文件
        CtClass cc = pool.get(className);
        // 获得指定方法名的方法
        CtMethod m = cc.getDeclaredMethod("doThing");
        // 在方法执行前插入代码
        m.insertBefore("{ System.out.println(\"记录日志\");}");
    }

    @Override
    public void start(ClassPool arg0) throws NotFoundException, CannotCompileException {
    }
    
    public static void main(String[] args) {
        Business b = new Business();
        b.doThing();
        b.doThing2();
    }
}

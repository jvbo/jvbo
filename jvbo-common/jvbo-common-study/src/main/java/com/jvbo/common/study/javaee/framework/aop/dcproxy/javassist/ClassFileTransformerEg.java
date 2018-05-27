/*
 * ClassFileTransformerEg.java 2018年5月25日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javaee.framework.aop.dcproxy.javassist;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class ClassFileTransformerEg implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println(className);
        // 如果加载Business类才拦截
        if(!"com/jvbo/common/study/javaee/framework/aop/dcproxy/Business".equals(className))
            return null;
        
        // javassist的包名是用点分割的,需要转换
        if(className.indexOf("/") != -1)
            className = className.replaceAll("/", ".");
        
        try {
            // 通过包名获取类文件
            CtClass cc = ClassPool.getDefault().get(className);
            // 获得指定方法名的方法
            CtMethod cm = cc.getDeclaredMethod("doThing");
            // 在方法执行前插入代码
            cm.insertBefore("{System.out.println(\"记录日志\");}");
            return cc.toBytecode();
        } catch (NotFoundException | CannotCompileException | IOException e) {
        }
        return null;
    }

}

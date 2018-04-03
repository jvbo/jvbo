/*
 * ClassLoaderAndInstanceOf.java 2018年1月21日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器与instanceof关键字
 * @ClassName: ClassLoaderAndInstanceOf 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月21日
 */
public class ClassLoaderAndInstanceOf {

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader(){

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read();
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        
        Object obj = myLoader.loadClass("com.jvbo.common.study.javase.jvm.research.ClassLoaderAndInstanceOf").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.jvbo.common.study.javase.jvm.research.ClassLoaderAndInstanceOf);
    }

}

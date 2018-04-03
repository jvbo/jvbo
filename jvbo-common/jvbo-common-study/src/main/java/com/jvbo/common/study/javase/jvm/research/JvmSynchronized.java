/*
 * JvmSynchronized.java 2018年1月19日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * JvmSynchronized关键字的字节码指令
 * @ClassName: JvmSynchronized 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月19日
 */
public class JvmSynchronized {
    
    void onlyMe(JvmSynchronized f){
        synchronized(f){
            System.out.println("111111");
        }
    }
    
}

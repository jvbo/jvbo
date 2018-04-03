/*
 * SingletonEnum.java 2018年1月29日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.singleton;

public enum SingletonEnum {
    INSTANCE;
    
    public void use(){
        System.out.println("use");
    }
}

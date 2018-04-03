/*
 * UnsafeStates.java 2018年4月2日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

/**
 * 使内部的可变状态逸出(不要这么做)
 * @ClassName: UnsafeStates 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月2日
 */
public class UnsafeStates {
    private String[] states = new String[]{
        "1","2","3"
    };
    public String[] getStates(){return states;}
}

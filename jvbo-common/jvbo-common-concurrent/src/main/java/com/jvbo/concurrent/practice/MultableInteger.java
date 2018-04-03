/*
 * MultableInteger.java 2018年4月2日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import com.jvbo.concurrent.practice.annotation.NotThreadSafe;

/**
 * 非线程安全的可变整数类
 * @ClassName: MultableInteger 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月2日
 */
@NotThreadSafe
public class MultableInteger {
    
    private int value;
    
    public int get(){return value;}
    public void set(int value){this.value = value;}

}

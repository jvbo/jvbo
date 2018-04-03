/*
 * ThreeStooges.java 2018年4月3日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.HashSet;
import java.util.Set;

import com.jvbo.concurrent.practice.annotation.Immutable;

/**
 * 在可变对象的基础上构建的不可变类
 * @ClassName: ThreeStooges 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月3日
 */
@Immutable
public class ThreeStooges {
    private final Set<String> stooges = new HashSet<String>();
    
    public ThreeStooges(){
        stooges.add("1");
        stooges.add("2");
        stooges.add("3");
    }
    
    public boolean isStooge(String name){
        return stooges.contains(name);
    }
}

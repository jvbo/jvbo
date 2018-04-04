/*
 * BetterVector.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.Vector;

import com.jvbo.concurrent.practice.annotation.ThreadSafe;

/**
 * 扩展Vector并增加一个"若没有则添加"方法
 * @ClassName: BetterVector 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    public synchronized boolean putIfAbsent(E x){
        boolean absent = !contains(x);
        if(absent)
            add(x);
        return absent;
    }
}

/*
 * HiddenIterator.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.jvbo.concurrent.practice.annotation.GuardedBy;

/**
 * 隐藏在字符串连接中的迭代操作(不要这么做)
 * @ClassName: HiddenIterator 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
public class HiddenIterator {
    @GuardedBy("this")
    private final Set<Integer> set = new HashSet<>();
    
    public synchronized void add(Integer i){
        set.add(i);
    }
    
    public synchronized void remove(Integer i){
        set.remove(i);
    }
    
    public void addTenThingd(){
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            add(r.nextInt());
        }
        System.out.println("DEBUG: added ten elements to " + set);
    }
    
    public static void main(String[] args) {
        new HiddenIterator().addTenThingd();
    }
}

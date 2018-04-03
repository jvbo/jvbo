/*
 * Stack.java 2018年1月29日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 内存溢出
 * @ClassName: Stack 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月29日
 */
public class Stack {
    
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    public Stack(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }
    
    public Object pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        //return elements[size--];// 这样直接返回时有问题的 过期引用问题
        
        // 修改如下
        Object result = elements[--size];
        elements[size] = null;// 手动释放
        return result;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

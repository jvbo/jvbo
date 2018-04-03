/*
 * StackE.java 2018年2月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.stack;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class StackE<E> {
    
    private E[] elements;
    private int size = 0;
    private static final int DEFAUL_INITIAL_CAPACITY = 16;
    
    @SuppressWarnings("unchecked")
    public StackE(){
        elements = (E[])new Object[DEFAUL_INITIAL_CAPACITY];
    }
    
    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }
    
    public E pop(){
        if(size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null;
        return result;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void pushAll(Iterable<? extends E> src){
        for (E e : src) {
            push(e);
        }
    }
    
    public void popAll(Collection<? super E> dst){
        while(!isEmpty())
            dst.add(pop());
    }
    
    private void ensureCapacity() {
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        
    }
}

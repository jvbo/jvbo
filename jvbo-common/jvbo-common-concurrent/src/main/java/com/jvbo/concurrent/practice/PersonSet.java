/*
 * PersonSet.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.HashSet;
import java.util.Set;

import com.jvbo.concurrent.practice.annotation.GuardedBy;
import com.jvbo.concurrent.practice.annotation.ThreadSafe;

/**
 * 通过封闭机制来确保线程安全
 * @ClassName: PersonSet 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
@ThreadSafe
public class PersonSet {
    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<>();
    
    public synchronized void addPerson(Person p){
        mySet.add(p);
    }
    
    public synchronized boolean containsPerson(Person p){
        return mySet.contains(p);
    }
    
    private static class Person{}
}

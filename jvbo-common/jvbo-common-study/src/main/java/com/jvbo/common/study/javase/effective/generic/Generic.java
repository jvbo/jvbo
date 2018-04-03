/*
 * Generic.java 2018年2月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.generic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Generic {
    
    public static Set union1(Set s1, Set s2){
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
    
    public static <E> Set<E> union2(Set<E> s1, Set<E> s2){
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }
    
    public static <K, V> HashMap<K, V> newHashMap(){
        return new HashMap<K, V>();
    }

    public static void main(String[] args) {
        Set<String> stringSet1 = new HashSet<String>(
                Arrays.asList("1","2","3"));
        Set<String> stringSet2 = new HashSet<String>(
                Arrays.asList("4","5","6"));
        Set<String> stringSet = union2(stringSet1, stringSet2);
        System.out.println(stringSet);
    }

}

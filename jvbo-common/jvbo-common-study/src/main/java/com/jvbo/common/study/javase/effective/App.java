/*
 * App.java 2018年1月29日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Boolean flag = Boolean.valueOf(true);
        System.out.println(System.identityHashCode(flag));
        Boolean flag1 = Boolean.valueOf(true);
        System.out.println(System.identityHashCode(flag1));
        flag1 = false;
        System.out.println(System.identityHashCode(flag1));
        flag1 = true;
        System.out.println(System.identityHashCode(flag1));
        BigInteger i = BigInteger.valueOf(1);
        System.out.println(BigInteger.probablePrime(2, new Random()));
        String str = String.valueOf('a');

        //EnumSet
        
        List<String> strList = new ArrayList<>();
        
        float a = .75f;
        System.out.println(a);
        
        System.out.println(1 << 30);
        
    }
}

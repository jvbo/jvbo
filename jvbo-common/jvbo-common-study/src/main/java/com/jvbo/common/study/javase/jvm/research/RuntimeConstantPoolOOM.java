/*
 * RuntimeConstantPoolOOM.java 2018年1月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: RuntimeConstantPoolOOM 
 * @Description: vm args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author jvbo
 * @date 2018年1月10日
 */
public class RuntimeConstantPoolOOM {
    /**
     * result:OpenJDK 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
     * jdk8已经去除PermSize了
     */
    public static void main(String[] args) {
        // 使用list保持着常量池的引用,避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
        
        /*String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);*/
        
        /*String s = new String("1");
        System.out.println("s:" + System.identityHashCode(s));
        String a = s.intern();
        System.out.println("a:" + System.identityHashCode(a));
        String s2 = "1";
        System.out.println("s2:" + System.identityHashCode(s2));
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");//new String("11");
        System.out.println("s3:" + System.identityHashCode(s3));
        String b = s3.intern();
        System.out.println("b:" + System.identityHashCode(b));
        String s4 = "11";
        System.out.println("s4:" + System.identityHashCode(s4));
        System.out.println(s3 == s4);
        
        
        
        String i = new String("ab");
        String j = "ab";
        System.out.println(i==j);*/
    }

}

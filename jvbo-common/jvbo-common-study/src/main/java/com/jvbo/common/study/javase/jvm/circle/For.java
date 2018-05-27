/*
 * For.java 2018年5月23日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.circle;

import java.util.Arrays;
import java.util.List;

public class For {
    /**
     * 1. 进入文件目录 javac -encoding UTF-8 -g For.java
     * 2. javap -verbose -private For  查看class文件内容
     */
    
    private static List<Integer> list;
    
    static {
        list.add(1);
        list.add(2);
        list.add(3);
    }
    
    public static void main(String[] args) {
        forUse();
    }

    public static void forUse(){
        for (;;) {
            if(list.isEmpty()){
                break;
            }else{
                list.remove(0);
                System.out.println(Arrays.toString(list.toArray()));
            }
        }
    }
}

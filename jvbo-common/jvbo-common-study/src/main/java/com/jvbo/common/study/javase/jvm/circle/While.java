/*
 * While.java 2018年5月23日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.circle;

import java.util.Arrays;
import java.util.List;

public class While {
    /**
     * 1. 进入文件目录 javac -encoding UTF-8 -g While.java
     * 2. javap -verbose -private While  查看class文件内容
     */
    
    private static List<Integer> list;
    
    static {
        list.add(1);
        list.add(2);
        list.add(3);
    }
    
    public static void main(String[] args) {
        whileUse();
    }
    
    public static void whileUse(){
        while(true){
            if(list.isEmpty()){
                break;
            }else{
                list.remove(0);
                System.out.println(Arrays.toString(list.toArray()));
            }
        }
    }
}

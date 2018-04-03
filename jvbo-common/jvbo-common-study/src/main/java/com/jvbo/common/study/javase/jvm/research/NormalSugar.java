/*
 * NormalSugar.java 2018年3月18日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 常用语法糖 自动装箱与拆箱
 * @ClassName: NormalSugar 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月18日
 */
public class NormalSugar {

    /*public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum = 0;
        for(int i : list){
            sum += i;
        }
        System.out.println(sum);
    }*/
    
    /*public static void main(String[] args) {
        List list = Arrays.asList(new Integer[]{
                Integer.valueOf(1),
                Integer.valueOf(2),
                Integer.valueOf(3),
                Integer.valueOf(4)
        });
        int sum = 0;
        for (Iterator localIterator = list.iterator(); localIterator.hasNext();){
            int i = ((Integer) localIterator.next()).intValue();
            sum += i;
        }
        System.out.println(sum);
    }*/
    
    /**
     * 建议实际编码中尽量避免下面的自动装箱与拆箱
     * @Description: TODO
     * @param @param args   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月18日
     */
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);// true
        System.out.println(e == f);// false Integer -128~128
        System.out.println(e.intValue() == f.intValue());// true
        System.out.println(d == (a + b));// true
        System.out.println(c.equals(a + b));// true
        System.out.println(g == (a + b));// true
        System.out.println(g.equals(a + b));// false
        System.out.println(g.intValue() == (a + b));//true
    }

}

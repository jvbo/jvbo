/*
 * Price.java 2018年7月22日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.job.temp;

import java.util.ArrayList;
import java.util.List;

public class Price {
    
    List<Integer> originData = new ArrayList<>();
    
    public void init(){
        originData.add(0);
        originData.add(10);
        originData.add(0);
        originData.add(10);
        originData.add(0);
        originData.add(10);
        originData.add(20);
        originData.add(10);
        originData.add(0);
        originData.add(10);
        originData.add(400);
        originData.add(600);
        originData.add(800);
        originData.add(1000);
        originData.add(2200);
    }
    
    private static final int start = -10;// 过滤差值start
    private static final int end = 10;// 过滤差值end
    private static final int count = 4;//连续多少个满足,i+1
    
    public static void main(String[] args) {
        Price price = new Price();
        price.init();
        List<Integer> origin = price.originData;
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for (int i = 0, length = origin.size(); i < length - 1; i++) {
             int one = origin.get(i);
             int two = origin.get(i + 1);
             int plus = two - one;
             first.add(plus);
        }
        
        for (int i = 0; i < count; i++) {
            int num = first.get(i);
            if(num >= start && num <= end){
                second.add(num);
            }
        }
        
        if(second.size() == count){
            System.out.println("1");
        }
    }
}

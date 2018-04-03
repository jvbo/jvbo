/*
 * RandomArray.java 2018年3月21日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.job.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class RandomArray {
    
    /**
     * 写一个函数，它的作用是接受一个整数（假设为length），返回一个数组，
     * 数组的长度为length，数组中的内容为随机的0至（length－1）的值，
     * 并且不能重复。比如length为5的话，数组可能是[1,0,3,2,4]。
     */
    public static int[] random(int length){
        if(length < 0)
            return new int[0];
        List<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            intList.add(i);
        }
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            int temp = intList.remove(new Random().nextInt(length - i));
            System.out.println(temp);
            array[i] = temp;
        }
        return array;
    }
    
    public static void main(String[] args) {
        int[] array = RandomArray.random(5);
        System.out.println(Arrays.toString(array));
    }
}

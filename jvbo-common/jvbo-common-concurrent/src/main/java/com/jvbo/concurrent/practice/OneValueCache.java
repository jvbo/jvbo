/*
 * OneValueCache.java 2018年4月3日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.math.BigInteger;
import java.util.Arrays;

import com.jvbo.concurrent.practice.annotation.Immutable;

/**
 * 对数值及其因数分解结果进行缓存的不可变容器类
 * @ClassName: OneValueCache 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月3日
 */
@Immutable
public class OneValueCache {
    
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;
    
    public OneValueCache(BigInteger i, BigInteger[] factors){
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors, factors.length);
    }
    
    public BigInteger[] getFactors(BigInteger i){
        if(lastNumber == null || !lastNumber.equals(i))
            return null;
        else
            return Arrays.copyOf(lastFactors, lastFactors.length);
    }
    
    public static void main(String[] args) {
        int[] intArr = new int[]{1, 2, 3, 4};
        int[] intChangeArr = Arrays.copyOf(intArr, intArr.length);
        System.out.println(Arrays.toString(intChangeArr));
        intChangeArr[0] = 0;
        System.out.println(Arrays.toString(intChangeArr));
    }

}

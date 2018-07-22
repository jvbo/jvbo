/*
 * IntegerReverse.java 2018年5月7日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.leetcode.str.reverse;

/**
 * 32位整数反转
 * @ClassName: IntegerReverse 
 * @Description: TODO
 * @author jvbo
 * @date 2018年5月7日
 */
public class IntegerReverse {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    /**
     * 1. 字符串法
     * @Description: TODO
     * @param @param x   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年5月7日
     */
    public static int reverseoOne(int x){
        int temp = Math.abs(x);
        String str = Integer.toString(temp);
        StringBuilder sb = new StringBuilder(str);
        String result = sb.reverse().toString();
        if(Long.parseLong(result) > Integer.MAX_VALUE){ // 用long来定义result,防止溢出问题
            result = "0";
        }
        return x > 0 ? Integer.parseInt(result) : -Integer.parseInt(result);
    }
    
    /**
     * 2. 模十取余法
     * @Description: TODO
     * @param @param x   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年5月7日
     */
    public static int reverseTwo(int x){
        long result = 0; // 用long来定义result,防止溢出问题
        int temp = Math.abs(x);
        while(temp > 0){
            result *= 10;
            result += temp % 10;
            if(result > Integer.MAX_VALUE){
                return 0;
            }
        }
        return (int)(x > 0 ? result : -result);
    }
    

}

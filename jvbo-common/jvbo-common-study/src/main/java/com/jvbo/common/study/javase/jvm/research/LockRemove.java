/*
 * LockRemove.java 2018年3月19日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * 锁优化技术之锁消除
 * @ClassName: LockRemove 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月19日
 */
public class LockRemove {

    public static void main(String[] args) {
        
    }
    
    public String concatString(String s1, String s2, String s3){
        return s1 + s2 + s3;
    }

}

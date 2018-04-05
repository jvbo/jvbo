/*
 * ExpensiveFunction.java 2018年4月5日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.cache;

import java.math.BigInteger;

/**
 * 使用HashMap和同步机制来初始化缓存
 * @ClassName: ExpensiveFunction 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月5日
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        // 经过长时间的计算后
        return new BigInteger(arg);
    }

}

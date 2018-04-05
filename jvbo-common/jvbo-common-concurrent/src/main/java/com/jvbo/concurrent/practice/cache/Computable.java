/*
 * Computable.java 2018年4月5日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.cache;

/**
 * 使用HashMap和同步机制来初始化缓存
 * @ClassName: Computable 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月5日
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}

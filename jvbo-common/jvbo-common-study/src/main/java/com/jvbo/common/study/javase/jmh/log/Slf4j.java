/*
 * Slf4j.java 2018年1月19日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jmh.log;

import org.openjdk.jmh.annotations.Benchmark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4j {
    
    private static final Logger logger = LoggerFactory.getLogger(Slf4j.class);
    
    @Benchmark
    public void slf4jTestPlus(){
        logger.info("slf4jTestPlus:" + "111111");
    }
    
    @Benchmark
    public void slf4jTestParam(){
        logger.info("slf4jTestParam:{}", "111111");
    }
}

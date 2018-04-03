/*
 * Log4j.java 2018年1月19日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jmh.log;

import org.apache.log4j.Logger;
import org.openjdk.jmh.annotations.Benchmark;

public class Log4j {
    
    private static final Logger logger = Logger.getLogger(Log4j.class);

    @Benchmark
    public void log4jTest(){
        logger.info("log4jTest:{}" + "111111");
    }
}

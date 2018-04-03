/*
 * CommonLog.java 2018年1月19日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jmh.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openjdk.jmh.annotations.Benchmark;

public class CommonLog {
    
    private static final Log logger = LogFactory.getLog(CommonLog.class);
    
    @Benchmark
    public void commonLogTest(){
        logger.info("CommonLog:{}" + "111111");
    }
}

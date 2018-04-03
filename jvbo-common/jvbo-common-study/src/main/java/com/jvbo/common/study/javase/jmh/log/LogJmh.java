/*
 * LogJmh.java 2018年1月19日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jmh.log;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class LogJmh {
    
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                /*.include("")
                .exclude("")*/
                .warmupIterations(10)
                .measurementIterations(10)
                .forks(3)
                .build();
        new Runner(opt).run();
    }
}

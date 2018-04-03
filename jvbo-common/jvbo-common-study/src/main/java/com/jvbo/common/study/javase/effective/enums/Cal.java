/*
 * Cal.java 2018年2月11日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.enums;

public enum Cal {
    PLUS{double apply(double x, double y){return x + y;}},
    MINUS{double apply(double x, double y){return x - y;}},
    TIMES{double apply(double x, double y){return x * y;}},
    DIVIDE{double apply(double x, double y){return x / y;}};
    
    abstract double apply(double x, double y);
}

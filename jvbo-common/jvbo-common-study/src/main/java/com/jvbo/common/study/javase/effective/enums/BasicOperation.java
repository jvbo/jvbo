/*
 * BasicOperation.java 2018年2月11日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.enums;

/**
 * 第35条:使用接口模拟可伸缩的枚举
 * @ClassName: BasicOperation 
 * @Description: TODO
 * @author jvbo
 * @date 2018年2月11日
 */
public enum BasicOperation implements Operation {
    PLUS("+"){
        public double apply(double x, double y){
            return x + y;
        }
    },
    MINUS("-"){
        public double apply(double x, double y){
            return x - y;
        }
    },
    TIMES("*"){
        public double apply(double x, double y){
            return x * y;
        }
    },
    DIVIDE("/"){
        public double apply(double x, double y){
            return x / y;
        }
    };
    
    private final String symbol;
    
    BasicOperation(String symbol){
        this.symbol = symbol;
    }
    
    @Override
    public String toString(){
        return symbol;
    }
}

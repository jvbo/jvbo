/*
 * Expression.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.interpreter;

/**
 * 抽象表达式角色
 * @ClassName: Expression 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public abstract class Expression {
	//以环境为准，本方法解释给定的任何一个表达式
    public abstract boolean interpret(Context ctx);
    
    //检验两个表达式在结构上是否相同
    public abstract boolean equals(Object obj);
    
    //返回表达式的hashCode
    public abstract int hashCode();
    
    //将表达式转换成字符串
    public abstract String toString();
}

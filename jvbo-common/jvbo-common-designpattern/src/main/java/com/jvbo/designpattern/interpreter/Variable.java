/*
 * Variable.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.interpreter;

/**
 * 一个Variable对象代表一个有名变量
 * @ClassName: Variable 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Variable extends Expression {
	
	private String name;

    public Variable(String name){
        this.name = name;
    }

	@Override
	public boolean interpret(Context ctx) {
        return ctx.lookup(this);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Variable){
            return this.name.equals(((Variable)obj).name);
        }
        return false;
	}

	@Override
	public int hashCode() {
        return this.toString().hashCode();
	}

	@Override
	public String toString() {
        return name;
	}

}

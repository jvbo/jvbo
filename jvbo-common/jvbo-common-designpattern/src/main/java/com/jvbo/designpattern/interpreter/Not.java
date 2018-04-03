/*
 * Not.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.interpreter;

/**
 * 代表逻辑"非"操作的Not类,
 * 代表由一个布尔表达式通过逻辑"非"操作给出一个新的布尔表达式的操作
 * @ClassName: Not 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Not extends Expression {
	
	private Expression exp;
    
    public Not(Expression exp){
        this.exp = exp;
    }

	@Override
	public boolean interpret(Context ctx) {
        return !exp.interpret(ctx);
	}

	@Override
	public boolean equals(Object obj) {
        if(obj != null && obj instanceof Not){
            return exp.equals(((Not)obj).exp);
        }
        return false;
	}

	@Override
	public int hashCode() {
        return this.toString().hashCode();
	}

	@Override
	public String toString() {
        return "(Not " + exp.toString() + ")";
	}

}

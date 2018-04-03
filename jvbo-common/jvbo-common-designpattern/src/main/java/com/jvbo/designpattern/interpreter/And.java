/*
 * And.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.interpreter;

/**
 * 代表逻辑"与"操作的And类,
 * 表示由两个布尔表达式通过逻辑"与"操作给出一个新的布尔表达式的操作
 * @ClassName: And 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class And extends Expression {
	
	private Expression left,right;
    
    public And(Expression left , Expression right){
        this.left = left;
        this.right = right;
    }

	@Override
	public boolean interpret(Context ctx) {
        return left.interpret(ctx) && right.interpret(ctx);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof And){
            return left.equals(((And)obj).left) && right.equals(((And)obj).right);
        }
        return false;
	}

	@Override
	public int hashCode() {
        return this.toString().hashCode();
	}

	@Override
	public String toString() {
        return "(" + left.toString() + " AND " + right.toString() + ")";
	}

}

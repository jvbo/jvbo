/*
 * And.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.interpreter;

/**
 * 代表逻辑"或"操作的Or类,
 * 代表由两个布尔表达式通过逻辑"或"操作给出一个新的布尔表达式的操作
 * @ClassName: And 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Or extends Expression {
	
	private Expression left,right;
    
    public Or(Expression left , Expression right){
        this.left = left;
        this.right = right;
    }

	@Override
	public boolean interpret(Context ctx) {
        return left.interpret(ctx) || right.interpret(ctx);
	}

	@Override
	public boolean equals(Object obj) {
        if(obj != null && obj instanceof Or){
            return this.left.equals(((Or)obj).left) && this.right.equals(((Or)obj).right);
        }
        return false;
	}

	@Override
	public int hashCode() {
        return this.toString().hashCode();
	}

	@Override
	public String toString() {
        return "(" + left.toString() + " Or " + right.toString() + ")";
	}

}

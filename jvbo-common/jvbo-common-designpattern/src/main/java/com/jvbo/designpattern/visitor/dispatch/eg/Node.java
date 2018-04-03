/*
 * Node.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.eg;

/**
 * 抽象节点角色
 * @ClassName: Node 
 * @Description: 声明一个接受操作,接受一个访问者对象作为一个参数;
 * @author jvbo
 * @date 2017年11月13日
 */
public abstract class Node {
	//接受操作
	public abstract void accept(Visitor visitor);
}

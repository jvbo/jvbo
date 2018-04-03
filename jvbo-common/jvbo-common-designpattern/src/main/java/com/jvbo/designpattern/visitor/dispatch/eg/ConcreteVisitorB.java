/*
 * ConcreteVisitorB.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.eg;

/**
 * 具体访问者角色
 * @ClassName: ConcreteVisitorB 
 * @Description: 实现抽象访问者所声明的接口,也就是抽象访问者所声明的各个访问操作;
 * @author jvbo
 * @date 2017年11月13日
 */
public class ConcreteVisitorB implements Visitor {

	@Override
	public void visit(ConcreteNodeA node) {
		System.out.println(node.operationA());
	}

	@Override
	public void visit(ConcreteNodeB node) {
		System.out.println(node.operationB());
	}
	
}

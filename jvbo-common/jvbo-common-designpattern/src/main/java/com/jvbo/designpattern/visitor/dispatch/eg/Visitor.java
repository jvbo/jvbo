/*
 * Visitor.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.eg;

/**
 * 抽象访问者角色
 * @ClassName: Visitor 
 * @Description: 声明了一个或者多个方法操作,形成所有的具体访问者角色必须实现的接口;
 * @author jvbo
 * @date 2017年11月13日
 */
public interface Visitor {
	//访问ConcreteNodeA
	void visit(ConcreteNodeA node);
	//访问ConcreteNodeB
	void visit(ConcreteNodeB node);
}

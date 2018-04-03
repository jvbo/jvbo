/*
 * ConcreteNodeB.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.eg;

/**
 * 具体节点角色
 * @ClassName: ConcreteNodeB 
 * @Description: 实现了抽象节点所规定的接受操作
 * @author jvbo
 * @date 2017年11月13日
 */
public class ConcreteNodeB extends Node {
	
	//接受操作
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    //特有的方法
    public String operationB(){
        return "ConcreteNodeB";
    }
}

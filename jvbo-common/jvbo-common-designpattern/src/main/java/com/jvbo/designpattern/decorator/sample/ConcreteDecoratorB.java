/*
 * ConcreteDecoratorB.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.decorator.sample;

/**
 * 具体装饰角色
 * @ClassName: ConcreteDecoratorB 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class ConcreteDecoratorB extends Decorator {

	public ConcreteDecoratorB(Component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}
	
	public void sampleOperation(){
		super.sampleOperation();
		//TODO 业务代码
	}
	
}

/*
 * AbstractTemplate.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.template.sample;

/**
 * 抽象模板角色
 * @ClassName: AbstractTemplate 
 * @Description: 1.定义了一个或多个抽象操作,以便让子类实现,这些抽象操作叫做基本操作,
 * 是一个顶级逻辑的组成步骤;
 * 2.定义并实现了一个模板方法,这个模板方法一般是一个具体方法,它给出了一个顶级逻辑的骨架,
 * 而逻辑的组成步骤在相应的抽象操作中,推迟到子类实现,顶级逻辑也有可能调用一些具体方法;
 * @author jvbo
 * @date 2017年11月10日
 */
public abstract class AbstractTemplate {
	//模板方法
	public void templateMethod(){
		//调用基本方法
		abstractMethod();
		hookMethod();
		concreteMethod();
	}
	
	//基本方法的声明(由子类实现)
	protected abstract void abstractMethod();

	//基本方法(空方法)
	protected void hookMethod(){};
	
	//基本方法(已经实现)
	private final void concreteMethod() {
		// TODO Auto-generated method stub
		
	}
}

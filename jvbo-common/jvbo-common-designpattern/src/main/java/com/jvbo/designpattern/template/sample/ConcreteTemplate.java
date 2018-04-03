/*
 * ConcreteTemplate.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.template.sample;

/**
 * 具体模板角色
 * @ClassName: ConcreteTemplate 
 * @Description: 1.实现父类所定义的一个或多个抽象方法,是一个顶级逻辑的组成步骤;
 * 2.每一个抽象模板角色都可以有任意多个具体模板角色与之对应,
 * 而每一个具体模板角色都可以给出这些抽象方法(即顶级逻辑的组成步骤)的不同实现,
 * 从而使顶级逻辑的实现各不相同;
 * @author jvbo
 * @date 2017年11月10日
 */
public class ConcreteTemplate extends AbstractTemplate {

	@Override
	protected void abstractMethod() {
		// TODO Auto-generated method stub
		
	}
	
	//重写父类方法
	@Override
	public void hookMethod(){
		//TODO 业务逻辑
	}

}

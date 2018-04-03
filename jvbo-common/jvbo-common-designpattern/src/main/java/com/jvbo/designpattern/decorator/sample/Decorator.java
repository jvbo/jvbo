/*
 * Decorator.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.decorator.sample;

/**
 * 装饰角色
 * @ClassName: Decorator 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class Decorator implements Component {
	
	private Component component;
	
	public Decorator(Component component){
		this.component = component;
	}
	

	@Override
	public void sampleOperation() {
		//委派给构建
		component.sampleOperation();
	}

}

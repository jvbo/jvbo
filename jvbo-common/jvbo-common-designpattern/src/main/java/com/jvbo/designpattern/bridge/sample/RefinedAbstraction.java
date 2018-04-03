/*
 * RefinedAbstraction.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.bridge.sample;

/**
 * 修正抽象化角色
 * @ClassName: RefinedAbstraction 
 * @Description: 扩展抽象化角色,改变和修正父类对抽象化的定义
 * @author jvbo
 * @date 2017年11月10日
 */
public class RefinedAbstraction extends Abstraction {

	public RefinedAbstraction(Implementor impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	//其他的操作方法
	public void otherOperation(){
		
	}
	
}

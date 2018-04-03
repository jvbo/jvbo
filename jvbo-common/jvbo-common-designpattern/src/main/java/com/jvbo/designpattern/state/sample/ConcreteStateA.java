/*
 * ConcreteStateA.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.state.sample;

/**
 * 具体状态角色
 * @ClassName: ConcreteStateA 
 * @Description: 每一个具体状态类都实现了环境(context)的一个状态所对应的行为;
 * @author jvbo
 * @date 2017年11月13日
 */
public class ConcreteStateA implements State {

	@Override
	public void handle(String sampleParameter) {
		System.out.println("ConcreteStateA handle:" + sampleParameter);
	}

}

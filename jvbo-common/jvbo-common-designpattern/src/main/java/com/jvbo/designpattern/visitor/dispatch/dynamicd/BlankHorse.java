/*
 * BlankHorse.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.dynamicd;

public class BlankHorse extends Horse {

	/**
	 * @Description: TODO
	 * @param    
	 * @return  
	 * @throws
	 * @author jvbo
	 * @date 2017年11月13日
	 */
	@Override
	public void eat() {
		//super.eat();
		System.out.println("黑马吃草");
	}
	
}

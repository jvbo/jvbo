/*
 * Change.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.decorator.eg;

/**
 * 抽象装饰角色-七十二变
 * @ClassName: Change 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class Change implements TheGreatestSage {
	
	private TheGreatestSage sage;
	
	public Change(TheGreatestSage sage){
		this.sage = sage;
	}

	@Override
	public void move() {
		sage.move();
	}

}

/*
 * Bird.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.decorator.eg;

/**
 * 具体装饰角色-鸟儿
 * @ClassName: Bird 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class Bird extends Change {

	public Bird(TheGreatestSage sage) {
		super(sage);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void move(){
		System.out.println("Bird move");
	}

}

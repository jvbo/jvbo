/*
 * Fish.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.decorator.eg;

/**
 * 具体装饰角色-鱼儿
 * @ClassName: Fish 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class Fish extends Change {

	public Fish(TheGreatestSage sage) {
		super(sage);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void move(){
		System.out.println("Fish move");
	}

}

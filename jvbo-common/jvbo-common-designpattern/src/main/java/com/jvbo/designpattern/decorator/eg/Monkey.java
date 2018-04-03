/*
 * Monkey.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.decorator.eg;

/**
 * 具体构件角色-大圣本尊-猢狲类
 * @ClassName: Monkey 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class Monkey implements TheGreatestSage {

	@Override
	public void move() {
		System.out.println("Monkey move");
	}

}

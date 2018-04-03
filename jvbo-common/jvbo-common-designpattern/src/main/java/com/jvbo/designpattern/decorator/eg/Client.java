/*
 * Client.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.decorator.eg;

/**
 * 客户端类-装饰模式
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class Client {
	public static void main(String[] args) {
		TheGreatestSage sage = new Monkey();
		//第一种写法
		TheGreatestSage bird = new Bird(sage);
		TheGreatestSage fish = new Fish(bird);
		
		//第二种写法
		//TheGreatestSage fish = new Fish(new Bird(sage));
		
		fish.move();
	}
}

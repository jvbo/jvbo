/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.flyweight.sample;

/**
 * 享元模式-客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	
	/**
	 * 内蕴状态:是存储在享元对象内部,并且是不会随环境的改变而有所不同,
	 * 故一个享元可以具有内蕴状态并可以共享;
	 * 
	 * 外蕴状态:随环境的改变而改变,不可以共享,享元对象的外蕴状态必须有客户端保存,
	 * 并在享元对象被创建之后,在需要使用的时候再传入到享元对象内部,
	 * 外蕴状态不可以影响享元对象的内蕴状态,他们是互相独立的;
	 */
	
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight fly = factory.factory(new Character('a'));
		fly.operation("first call");
		
		fly = factory.factory(new Character('b'));
		fly.operation("second call");
		
		fly = factory.factory(new Character('a'));
		fly.operation("third call");
	}
	
}

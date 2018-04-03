/*
 * Client.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.composite.transparent;

/**
 * 客户端类-透明式合成模式
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class Client {
	
	public static void main(String[] args) {
		Component root = new Composite("服装");
		Component c1 = new Composite("男装");
		Component c2 = new Composite("女装");
		
		Component leaf1 = new Leaf("衬衫");
		Component leaf2 = new Leaf("夹克");
		Component leaf3 = new Leaf("裙子");
		Component leaf4 = new Leaf("套装");

		root.addChild(c1);
		root.addChild(c2);
		c1.addChild(leaf1);
		c1.addChild(leaf2);
		c2.addChild(leaf3);
		c2.addChild(leaf4);
		
		root.printStruct("我是");
	}
}

/**
 * 安全式合成模式:从客户端使用合成模式上看是否是更安全,如果是,那么就不会发生误操作的可能,
 * 能访问的方法都是被支持的;
 * 
 * 透明式合成模式:从客户端使用合成模式上看,是否需要区分是树枝对象还是树叶对象,如果透明,
 * 那就不用区分,对于客户而言,都是Component对象,具体类型对于客户端而言是透明的;
 * 
 * 对于合成模式而言,在安全性和透明性上,会更看重透明,
 * 合成模式的目的是:让客户端不在区分树枝对象还是树叶对象,以一个统一的方式来操作;
 * 
 * 而且对于安全性的实现而言,需要区分树枝对象和树叶对象,有时需要将对象进行类型转换,
 * 却发现类型信息丢失了,只好强制转换,这种类型转换必然是不安全的;
 * 
 * 因此在使用合成模式时,建议多采用透明性的实现方式;
 */

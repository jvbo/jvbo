/*
 * Client.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.composite.safe;

/**
 * 客户端类-安全式合成模式(备份-整体模式)
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class Client {
	/**
	 * 
	 */
	
	public static void main(String[] args) {
		Composite root = new Composite("服装");
		Composite c1 = new Composite("男装");
		Composite c2 = new Composite("女装");
		
		Leaf leaf1 = new Leaf("衬衫");
		Leaf leaf2 = new Leaf("夹克");
		Leaf leaf3 = new Leaf("裙子");
		Leaf leaf4 = new Leaf("套装");
		
		root.addChild(c1);
		root.addChild(c2);
		c1.addChild(leaf1);
		c1.addChild(leaf2);
		c2.addChild(leaf3);
		c2.addChild(leaf4);
		
		root.printStruct("我是");
	}
	
}

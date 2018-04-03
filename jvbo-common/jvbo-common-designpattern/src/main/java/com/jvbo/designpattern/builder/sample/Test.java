/*
 * Test.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.sample;

/**
 * 建造模式-测试类
 * @ClassName: Test 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public class Test {
	public static void main(String[] args) {
		Builder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		director.construct();
		Product product = builder.retrieveResult();
		System.out.println(product.getPart1());
		System.out.println(product.getPart2());
	}
}

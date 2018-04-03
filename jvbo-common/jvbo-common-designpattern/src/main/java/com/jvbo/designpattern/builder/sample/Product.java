/*
 * Product.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.sample;

/**
 * 产品类
 * @ClassName: Product 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public class Product {
	/**
	 * 一些关于产品的操作
	 */
	private String part1;
	private String part2;
	
	
	public String getPart1() {
		return part1;
	}
	public void setPart1(String part1) {
		this.part1 = part1;
	}
	public String getPart2() {
		return part2;
	}
	public void setPart2(String part2) {
		this.part2 = part2;
	}
}

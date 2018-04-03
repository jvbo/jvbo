/*
 * Price.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.strategy.eg;

/**
 * 价格类
 * @ClassName: Price 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Price {
	private MemberStrategy strategy;
	
	public Price(MemberStrategy strategy){
		this.strategy = strategy;
	}
	
	public double quote(double booksPrice){
		return this.strategy.calcPrice(booksPrice);
	}
}

/*
 * AdvancedMemberStrategy.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.strategy.eg;

/**
 * 高级会员折扣类
 * @ClassName: AdvancedMemberStrategy 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class AdvancedMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("高级会员,折扣20%");
		return booksPrice * 0.8;
	}

}

/*
 * PrimaryMemberStrategy.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.strategy.eg;

/**
 * 初级会员折扣类
 * @ClassName: PrimaryMemberStrategy 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class PrimaryMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("初级会员,无折扣");
		return booksPrice;
	}

}

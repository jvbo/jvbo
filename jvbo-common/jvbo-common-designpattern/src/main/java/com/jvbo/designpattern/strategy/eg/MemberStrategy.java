/*
 * MemberStrategy.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.strategy.eg;

/**
 * 抽象折扣类
 * @ClassName: MemberStrategy 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public interface MemberStrategy {
	double calcPrice(double booksPrice);
}

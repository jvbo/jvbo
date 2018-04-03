/*
 * MoneyMarketAccount.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.template.eg;

/**
 * 具体模板角色类
 * @ClassName: MoneyMarketAccount 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class MoneyMarketAccount extends Account {

	@Override
	protected String doCalculateAccountType() {
		return "Money Market";
	}

	@Override
	protected double doCalculateInterestRate() {
		return 0.045;
	}

}

/*
 * CDAccount.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.template.eg;

/**
 * 具体模板角色类
 * @ClassName: CDAccount 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class CDAccount extends Account {

	@Override
	protected String doCalculateAccountType() {
		return "Certificate of Deposite";
	}

	@Override
	protected double doCalculateInterestRate() {
		return 0.06;
	}

}

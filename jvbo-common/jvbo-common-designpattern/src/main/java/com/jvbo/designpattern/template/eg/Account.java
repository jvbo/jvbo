/*
 * Account.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.template.eg;

/**
 * 抽象模板角色类
 * @ClassName: Account 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public abstract class Account {
	//模板方法,计算利息数额
	public final double calculateInterest(){
        double interestRate = doCalculateInterestRate();
        String accountType = doCalculateAccountType();
        double amount = calculateAmount(accountType);
        return amount * interestRate;
    }
	
	//基本方法留给子类实现
	protected abstract String doCalculateAccountType();
	
	
	//基本方法留给子类实现
	protected abstract double doCalculateInterestRate();
	
	//基本方法,已经实现
	private double calculateAmount(String accountType){
        return 1234.00;
    }
}

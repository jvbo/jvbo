/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.template.eg;

/**
 * 模板方法模式
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	public static void main(String[] args) {
        Account account = new MoneyMarketAccount();
        System.out.println("货币市场:" + account.calculateInterest());
        account = new CDAccount();
        System.out.println("定期账号:" + account.calculateInterest());
    }
}

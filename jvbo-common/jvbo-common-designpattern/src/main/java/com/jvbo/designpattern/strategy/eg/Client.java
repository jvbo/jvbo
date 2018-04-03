/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.strategy.eg;

/**
 * 策略模式-客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	public static void main(String[] args) {
		//选择并创建需要使用的策略对象
		MemberStrategy strategy = new AdvancedMemberStrategy();
		//创建环境
		Price price = new Price(strategy);
		//计算价格
		double quote = price.quote(300);
		System.out.println("图书最终价格: " + quote);
	}
}

/**
 * 策略模式优点:
 * 1.提供了管理相关的算法族的方法,策略类的等级结构定义了一个算法或行为族,
 * 恰当使用继承可以把公共的代码移到父类里面,避免了代码重复;
 * 2.可以避免使用多重条件语句,多重条件语句不易维护,
 * 多重条件语句把采取哪一种算法或采取哪一种行为的逻辑与算法或行为的逻辑混合在一起,
 * 统统列在一个多重条件语句里面,比使用继承的办法还要原始和落后;
 * 
 * 策略模式的缺点:
 * 1.客户端必须知道所有的策略类,并自行决定使用哪一个策略类,这就意味着客户端必须理解这些算法的区别,
 * 以便适时选择恰当的算法类,换言之,策略模式只适用于客户端知道算法或行为的情况;
 * 2.由于策略模式把每个具体的策略实现都单独封装称为类,如果备选的策略很多,那么对象的数目就会很多;
 */

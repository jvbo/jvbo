/*
 * ConcreteHandler.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.chain.sample;

/**
 * 具体处理者角色
 * @ClassName: ConcreteHandler 
 * @Description: 具体处理者接到请求后,可以选择将请求处理掉,或者将请求传给下家;
 * 由于具体处理者持有对下家的引用,因此,如果需要,具体处理者可以访问下家;
 * @author jvbo
 * @date 2017年11月10日
 */
public class ConcreteHandler extends Handler {

	@Override
	public void handleRequester() {
		/**
		 * 判断是否有后继的责任对象,如果有,就转发请求给后继的责任对象,
		 * 如果没有,则处理请求
		 */
		if(getSuccessor() != null){
			System.out.println("放过请求");
			getSuccessor().handleRequester();
		}else{
			System.out.println("处理请求");
		}
	}
	
}

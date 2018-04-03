/*
 * Context.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.strategy.sample;

/**
 * 环境角色
 * @ClassName: Context 
 * @Description: 持有一个strategy对象的引用
 * @author jvbo
 * @date 2017年11月10日
 */
public class Context {
	//持有一个具体策略的对象
	private Strategy strategy;
	
	public Context(Strategy strategy){
		this.strategy = strategy;
	}
	
	//策略方法
	public void contextInterface(){
		strategy.strategyInterface();
	}
}

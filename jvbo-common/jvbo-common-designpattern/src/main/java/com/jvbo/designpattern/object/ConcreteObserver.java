/*
 * ConcreteObserver.java 2017年6月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.object;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 具体观察者角色类
 * @ClassName: ConcreteObserver 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月20日
 */
public class ConcreteObserver implements Observer {
	
	private static final Logger logger = LoggerFactory.getLogger(ConcreteObserver.class);
	
	private String observerState;
	
	@Override
	public void update(String state) {
		// TODO Auto-generated method stub
		//更新观察者状态，使其与目标状态一直
		this.observerState = state;
		logger.info("状态为：{}",observerState);
	}

}

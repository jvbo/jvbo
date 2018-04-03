/*
 * ConcreteSubject.java 2017年6月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.object;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 具体主题角色类
 * @ClassName: ConcreteSubject 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月20日
 */
public class ConcreteSubject extends Subject {
	
	private static final Logger logger = LoggerFactory.getLogger(ConcreteSubject.class);
	
	private String state;
	
	public String getState(){
		return this.state;
	}
	
	public void change(String newState){
		state = newState;
		logger.info("主题状态变为：{}", state);
		//状态改变，通知各个观察者
		this.notifyAllObserver(state);
	}
	
}

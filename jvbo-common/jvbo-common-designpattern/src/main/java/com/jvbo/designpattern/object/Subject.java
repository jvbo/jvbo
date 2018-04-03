/*
 * Subject.java 2017年6月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.object;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象主题角色类
 * @ClassName: Subject 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月20日
 */
public abstract class Subject {
	
	private static final Logger logger = LoggerFactory.getLogger(Subject.class);
	
	/*保存注册的观察者对象*/
	private List<Observer> list = new ArrayList<Observer>();
	
	/**
	 * 注册观察者对象
	 * @Description: TODO
	 * @param @param observer   
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年6月20日
	 */
	public void attach(Observer observer){
		list.add(observer);
		logger.info("attach an observer");
	}
	
	/**
	 * 删除观察者对象
	 * @Description: TODO
	 * @param @param observer   
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年6月20日
	 */
	public void detach(Observer observer){
		list.remove(observer);
		logger.info("detach an observer");
	}
	
	/**
	 * 通知所有注册的观察者对象
	 * @Description: TODO
	 * @param    
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年6月20日
	 */
	public void notifyAllObserver(String newState){
		for (Observer observer : list) {
			observer.update(newState);
		}
	}
}

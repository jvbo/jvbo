/*
 * Observer.java 2017年6月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.object;

/**
 * 抽象观察者角色类
 * @ClassName: Observer 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月20日
 */
public interface Observer {
	
	/**
	 * 更新接口
	 * @Description: TODO
	 * @param @param newState 状态
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年6月20日
	 */
	public void update(String newState);

}

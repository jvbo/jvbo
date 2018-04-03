/*
 * Iterator.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.iterator.egone;

/**
 * 抽象迭代子角色
 * @ClassName: Iterator 
 * @Description: 定义出遍历元素所需的接口;
 * @author jvbo
 * @date 2017年11月10日
 */
public interface Iterator {
	//迭代方法:移动到第一个元素
	void frist();
	
	//迭代方法:移动到下一个元素
	void next();
	
	//迭代方法:是否为最后一个元素
	boolean isDone();
	
	//迭代方法:返回当前元素
	Object currentItem();
}

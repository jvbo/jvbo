/*
 * Aggregate.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.iterator.egone;

/**
 * 聚集角色
 * @ClassName: Aggregate 
 * @Description: 给出创建迭代子(Iterator)对象的接口;
 * @author jvbo
 * @date 2017年11月10日
 */
public abstract class Aggregate {
	//工厂方法,创建相应迭代子对象的接口
	public abstract Iterator createIterator();
}

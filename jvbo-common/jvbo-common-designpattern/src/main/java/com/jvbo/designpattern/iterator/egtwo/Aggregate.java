/*
 * Aggregate.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.iterator.egtwo;

/**
 * 抽象聚集角色类
 * @ClassName: Aggregate 
 * @Description: 规定出所有的具体聚集必须实现的接口;
 * 迭代子模式要求聚集对象必须有一个工厂方法,也就是createIterator()方法,
 * 以向外界提供迭代子对象的实例;
 * @author jvbo
 * @date 2017年11月10日
 */
public abstract class Aggregate {
	//工厂方法,创建相应迭代子对象的接口
	public abstract Iterator createIterator();
}

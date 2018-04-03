/*
 * Flyweight.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.flyweight.sample;

/**
 * 抽象享元角色
 * @ClassName: Flyweight 
 * @Description: 给出一个接口,规定出所有具体享元角色需要实现的方法
 * @author jvbo
 * @date 2017年11月10日
 */
public interface Flyweight {
	
	//一个示意性方法,参数state是外蕴状态
	void operation(String state);
}

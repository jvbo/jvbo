/*
 * Builder.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.sample;

/**
 * 抽象建造者类
 * @ClassName: Builder 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public interface Builder {
	void buildPart1();
	
	void buildPart2();
	
	Product retrieveResult();
}

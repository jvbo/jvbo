/*
 * Director.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.sample;

/**
 * 导演者类
 * @ClassName: Director 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public class Director {
	//持有当前需要使用的建造器对象
	private Builder builder;
	
	/**
	 * 构造方法，传入建造器对象
	 * @param builder 建造器对象
	 */
	public Director(Builder builder){
		this.builder = builder;
	}
	
	/**
	 * 产品建造方法，负责调用各个零件建造方法
	 * @Description: TODO
	 * @param    
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年11月1日
	 */
	public void construct(){
		builder.buildPart1();
		builder.buildPart2();
	}
	
}

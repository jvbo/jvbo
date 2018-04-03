/*
 * ConcreteBuilder.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.sample;

/**
 * 具体建造者类
 * @ClassName: ConcreteBuilder 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public class ConcreteBuilder implements Builder {
	
	private Product product = new Product();
	
	//产品零件建造方法1
	@Override
	public void buildPart1() {
		//构建产品的第一个零件
		product.setPart1("编号：9527");
	}
	
	//产品零件建造方法2
	@Override
	public void buildPart2() {
		//构建产品的第二个零件
		product.setPart2("名称：jvbo");
	}
	
	//产品返还方法
	@Override
	public Product retrieveResult() {
		return product;
	}

}

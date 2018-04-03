/*
 * Test.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.abstractfactory;

/**
 * 抽象工厂模式-测试类
 * @ClassName: Test 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public class Test {
	/**
	 * 1.产品族与产品等级<==>平面直角坐标系
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		//装机工程师对象
		ComputerEngineer ce = new ComputerEngineer();
		//客户选择并创建需要的产品对象
		AbstractFactory af = new IntelFactory();
		//告诉装机工程师选择的产品，让装机工程师组装电脑
		ce.makeComputer(af);
	}

}

/**
 * 使用场景：
 * 1.一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有形态的工厂模式都是重要的；
 * 2.这个系统的产品有多余一个的产品族，而系统只消费其中某一族的产品；
 * 3.同属于一个产品族的产品是在一起使用的，这一切约束必须在系统的设计中体现出来；
 * 4.系统提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于实现；
 * 
 * 优点：
 * 1.分离接口和实现
 * 客户端使用抽象工厂来创建需要的角色，而其根本不知道具体的实现是谁，客户端只是面向产品的接口编程。
 * 即客户端从具体的产品实现中解耦了；
 * 2.使切换产品族变得容易
 * 因为一个具体的工厂代表的是一个产品族；
 * 
 * 缺点：
 * 1.不太容易扩展新的产品；
 * 若需要给整个产品族添加一个新的产品，需要修改抽象工厂，会导致需要修改所有的工厂实现类；
 **/

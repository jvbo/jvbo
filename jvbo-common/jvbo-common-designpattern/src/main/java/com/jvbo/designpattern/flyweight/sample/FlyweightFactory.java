/*
 * FlyweightFactory.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.flyweight.sample;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂角色
 * @ClassName: FlyweightFactory 
 * @Description: 负责创建和管理享元角色,必须保证享元对象可以被系统适当的共享,
 * 当一个客户端对象调用一个享元对象的时候,享元工厂角色会检查系统中是否已经有一个符合要求的享元对象,
 * 如果有了,享元工厂角色就应当提供这个已有的享元对象,
 * 如果系统中没有一个适当的享元对象,享元工厂角色就应当创建一个合适的享元对象;
 * @author jvbo
 * @date 2017年11月10日
 */
public class FlyweightFactory {
	
	private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();
	
	public Flyweight factory(Character state){
		//先从缓存中查找对象
		Flyweight fly = files.get(state);
		if(fly == null){
			//对象不存在,创建
			fly = new ConcreteFlyweight(state);
			//添加到缓存
			files.put(state, fly);
		}
		return fly;
	}
}

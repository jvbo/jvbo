/*
 * ConcreteCompositeFlyweight.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.flyweight.complex;

import java.util.HashMap;
import java.util.Map;

/**
 * 复合享元角色
 * @ClassName: ConcreteCompositeFlyweight 
 * @Description: 所代表的对象不可共享,但是一个复合享元对象可以分解成为多个本身是单纯享元对象的组合,
 * 复合享元对象又称作不可共享的享元对象
 * @author jvbo
 * @date 2017年11月10日
 */
public class ConcreteCompositeFlyweight implements Flyweight {
	
	private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();
	
	/**
	 * 增加一个单纯享元对象到聚集中
	 * @Description: TODO
	 * @param @param key
	 * @param @param value   
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年11月10日
	 */
	public void add(Character key, Flyweight value){
		files.put(key, value);
	}
	
	//外蕴状态作为参数传入到方法中
	@Override
	public void operation(String state) {
		Flyweight fly = null;
		for (Object o : files.keySet()) {
			fly = files.get(o);
			fly.operation(state);
		}
	}

}

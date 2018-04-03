/*
 * EnumSingleton.java 2017年10月31日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.singleton;

/**
 * 枚举单例
 * @ClassName: EnumSingleton 
 * @Description: TODO
 * @author jvbo
 * @date 2017年10月31日
 */
public enum EnumSingleton {
	/**
	 * 单元素的枚举类型已经成为实现Singleton的最佳方法
	 */
	/**
	 * 定义一个枚举的元素，代表Singleton的一个实例
	 */
	uniqueInstance;
	
	/**
	 * 单例自己的操作
	 * @Description: TODO
	 * @param    
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年10月31日
	 */
	public void singletonOperation(){
		//处理操作
	}
}
/**
 * 1.非常简洁，无偿提供了序列化机制(枚举与java序列化)
 * 2.由jvm缺省保证线程安全(枚举与线程安全)
 * 3.jdk1.5+后台使用
 */
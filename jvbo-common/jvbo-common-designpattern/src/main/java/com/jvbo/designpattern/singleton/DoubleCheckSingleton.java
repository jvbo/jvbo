/*
 * DoubleCheckSingleton.java 2017年10月31日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.singleton;

/**
 * 双重检查锁单例
 * @ClassName: DoubleCheckSingleton 
 * @Description: TODO
 * @author jvbo
 * @date 2017年10月31日
 */
public class DoubleCheckSingleton {
	/**
	 * 1.使用volatile关键字，jdk1.4+
	 * 2.只synchronized一次
	 */
	
	private volatile static DoubleCheckSingleton instance = null;
	
	private DoubleCheckSingleton(){}
	
	public static DoubleCheckSingleton getInstance(){
		//检查实例是否存在，不存在进入同步块
		if(instance == null){
			//同步块，线程安全的创建实例
			synchronized(DoubleCheckSingleton.class){
				//再次检查实例，不存在是创建
				if(instance == null){
					instance = new DoubleCheckSingleton();
				}
			}
			
		}
		return instance;
	}
	
}

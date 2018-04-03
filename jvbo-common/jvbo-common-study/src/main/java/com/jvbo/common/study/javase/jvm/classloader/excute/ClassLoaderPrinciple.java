/*
 * ClassLoaderPrinciple.java 2017年10月23日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.classloader.excute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类加载器工作原理
 * @ClassName: ClassLoaderPrinciple 
 * @Description: TODO
 * @author jvbo
 * @date 2017年10月23日
 */
public class ClassLoaderPrinciple {
	/**
	 * 1.java中的类大致分为3种：系统类 扩展类 程序员自己定义的类；
	 * 2.类装载方式有两种：隐式装载(程序在运行过程中当碰到new等方式生成对象时，隐式调用类装载器加载对应的类到jvm中)
	 * 显式装载(通过class.forname()等方法，显式加载需要的类)
	 * 3.类加载器动态性：一个应用程序总是有n多个类组成，java程序启动时，并不是一次把所有的类全部加载后再运行，
	 * 它总是先把保证程序运行的基础类一次性加载到jvm中，其他类等到jvm用到的时候再加载，这样的好处是减少了内存空间，
	 * 因为java最早就是为嵌入式系统而设计的，内存宝贵，这是一种可以理解的机制，用到是再加载这也是java动态性的一种体现；
	 * 4.java类装载器：java中的类装载器本质上也是累，功能是把类载入jvm中，值得注意的是jvm的类装载器并不是一个，而是三个，
	 * 层次结构分别是BootstrapLoader(负责加载系统类)->ExtClassLoader(负责加载扩展类)->AppClassLoader(负责加载应用类)；
	 */
	
	private static final Logger logger = LoggerFactory.getLogger(ClassLoaderPrinciple.class);
	
	/**
	 * 三个机制：
	 * 1.委托机制
	 * 
	 * 2.可见性机制
	 * 
	 * 3.单一性机制
	 */
	
	public static void main(String[] args) {
		System.out.println("ClassLoaderPrinciple.class.getClassLoader(): " 
				+ ClassLoaderPrinciple.class.getClassLoader());
		try {
			Class.forName("excute.ClassLoaderPrinciple", 
						true, 
						ClassLoaderPrinciple.class.getClassLoader().getParent());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.info("ClassNotFoundException:{}", e);
		}
	}
}

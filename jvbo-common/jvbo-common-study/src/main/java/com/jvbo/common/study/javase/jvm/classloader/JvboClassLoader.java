/*
 * JvboClassLoader.java 2017年10月17日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.classloader;

public class JvboClassLoader {

	public static void main(String[] args) {
		try {
			ClassLoader.getSystemClassLoader().loadClass("");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

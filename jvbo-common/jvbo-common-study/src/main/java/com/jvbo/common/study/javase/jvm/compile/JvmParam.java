/*
 * TestJvmParam.java 2018年1月5日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.compile;

import java.util.Arrays;

public class JvmParam {
	/**
	 * 1. 进入文件目录 javac -encoding UTF-8 -g JvmParam.java
	 * 2. javap -verbose -private JvmParam	查看class文件内容
	 */
	
	public static void main(String[] args) {
		Runnable r = () -> System.out.println(Arrays.toString(args));
		r.run();
	}
}

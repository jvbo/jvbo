/*
 * NoClassDefFoundErrorTest.java 2017年10月23日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.classloader.excute;

/**
 * NoClassDefFoundError异常重现
 * @ClassName: NoClassDefFoundErrorTest 
 * @Description: TODO
 * @author jvbo
 * @date 2017年10月23日
 */
public class NoClassDefFoundErrorTest {
	public static void main(String[] args) {
		/*try {
			SimpleCalculator calculator1 = new SimpleCalculator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SimpleCalculator calculator2 = new SimpleCalculator();*/
		
		System.out.println(SimpleCalculator.testError());
		
	}
}

class SimpleCalculator {
	public static String testError(){
		int i = 1/0;
		return "";
	}
}

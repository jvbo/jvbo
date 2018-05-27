/*
 * StrTest.java 2017年6月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.apachecommon;

import org.apache.commons.lang3.math.NumberUtils;

public class StrTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//subStr();
		//subtest();
		//stringMaxTest();
		//strLength();

        String userId = "1", storeId = "2";
	}
	
	public static void strLength(){
		String str = 
				new String("");
		System.out.println(str.length());
	}
	
	private static void stringMaxTest() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1070; i++) {
			sb.append(i+"");
		}
		System.out.println(sb.toString());
	}

	public static void subtest(){
		String str = "11111111111111";
		String result = str.substring(0, str.indexOf(str))+(NumberUtils.toLong(str)+1);
		System.out.println(result);
	}
	
	public static void subStr(){
		String str = "1,2,3,4,5,6,";
		System.out.println(str.substring(0, str.length() - 1));
	}

}

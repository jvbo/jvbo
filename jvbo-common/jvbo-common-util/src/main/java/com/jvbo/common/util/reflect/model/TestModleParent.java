/*
 * TestModle.java 2017年7月5日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.util.reflect.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestModleParent {
	
	public static final Logger logger = LoggerFactory.getLogger(TestModleParent.class);
	
	private String parentName;
	private int parentAge;
	private boolean parentSuccessFlag;
	
	
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public int getParentAge() {
		return parentAge;
	}

	public void setParentAge(int parentAge) {
		this.parentAge = parentAge;
	}

	public boolean isParentSuccessFlag() {
		return parentSuccessFlag;
	}

	public void setParentSuccessFlag(boolean parentSuccessFlag) {
		this.parentSuccessFlag = parentSuccessFlag;
	}

	public TestModleParent(){
		logger.info("TestModleParent默认无参构造方法");
	}

	public TestModleParent(String parentName, int parentAge, boolean parentSuccessFlag) {
		this.parentName = parentName;
		this.parentAge = parentAge;
		this.parentSuccessFlag = parentSuccessFlag;
		logger.info("TestModleParent有参构造方法");
	}
	
	public void outMsg(String msg){
		System.out.println("TestModleParent带参数简单输出信息：" + msg);
	}
	
}

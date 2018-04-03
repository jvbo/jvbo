/*
 * TestModleChild.java 2017年7月5日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.util.reflect.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestModleChild extends TestModleParent {
public static final Logger logger = LoggerFactory.getLogger(TestModleParent.class);
	
	private String childName;
	private int childAge;
	private boolean childSuccessFlag;
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public int getChildAge() {
		return childAge;
	}
	public void setChildAge(int childAge) {
		this.childAge = childAge;
	}
	public boolean isChildSuccessFlag() {
		return childSuccessFlag;
	}
	public void setChildSuccessFlag(boolean childSuccessFlag) {
		this.childSuccessFlag = childSuccessFlag;
	}
	
	public TestModleChild(){
		logger.info("TestModleChild默认无参构造方法");
	}
	
	public TestModleChild(String childName, int childAge, boolean childSuccessFlag) {
		super();
		this.childName = childName;
		this.childAge = childAge;
		this.childSuccessFlag = childSuccessFlag;
		logger.info("TestModleChild有参构造方法");
	}
	
	public void outMsg(String msg){
		System.out.println("TestModleChild带参数简单输出信息：" + msg);
	}
	
}

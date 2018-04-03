/*
 * State.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.state.sample;

/**
 * 抽象状态角色
 * @ClassName: State 
 * @Description: 定义一个接口,
 * 用以封装环境context对象的一个特定的状态所对应的行为;
 * @author jvbo
 * @date 2017年11月13日
 */
public interface State {
	//状态对应的处理
	void handle(String sampleParameter);

}

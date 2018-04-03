/*
 * Colleague.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.mediator.sample;

/**
 * 抽象同事类角色
 * @ClassName: Colleague 
 * @Description: 定义出调停者到同事对象的接口。同事对象只知道调停者而不知道其余的同事对象
 * @author jvbo
 * @date 2017年11月13日
 */
public abstract class Colleague {
	//持有一个调停者对象
	private Mediator mediator;
	
	public Colleague(Mediator mediator){
		this.mediator = mediator;
	}
	
	//获取当前同事类对应的调停者对象
	public Mediator getMediator() {
        return mediator;
    }
}

/*
 * Mediator.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.mediator.eg;

/**
 * 抽象调停者角色
 * @ClassName: Mediator 
 * @Description: 定义出同事对象到调停者对象的接口,其中主要方法是一个(或多个)事件方法;
 * @author jvbo
 * @date 2017年11月13日
 */
public interface Mediator {
	//同事对象在自身改变的时候来通知调停者方法,让调停者去负责相应的与其他同事对象的交互
	void changed(Colleague c);
}

/*
 * ConcreteColleagueB.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.mediator.sample;

/**
 * 具体同事类角色
 * @ClassName: ConcreteColleagueB 
 * @Description: 所有的具体同事类均从抽象同事类继承而来;
 * 实现自己的业务,在需要与其他同事通信的时候,就与持有的调停者通信,
 * 调停者会负责与其他的同事交互;
 * @author jvbo
 * @date 2017年11月13日
 */
public class ConcreteColleagueB extends Colleague {

	public ConcreteColleagueB(Mediator mediator) {
		super(mediator);
	}
	
	//示意方法,执行某些操作
	public void operation(){
		//在需要跟其他同事通信的时候,通知调停者对象
		getMediator().changed(this);
	}

}

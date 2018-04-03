/*
 * Implementor.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.bridge.sample;

/**
 * 实现化角色
 * @ClassName: Implementor 
 * @Description: 这个角色给出实现化角色的接口,但不给出具体的实现,必须指出,
 * 这个接口不一定和抽象化角色的接口定义相同,实际上,这两个接口可以非常不一样;
 * 实现化角色应当只给出底层操作,而抽象化角色应当只给出基于底层操作的更高一层的操作;
 * @author jvbo
 * @date 2017年11月10日
 */
public abstract class Implementor {

	public abstract void operationImpl();

}

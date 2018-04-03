/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.observer.pull;

/**
 * 观察者模式-客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	
}

/**
 * 推模型和拉模型比较
 * 1.推模型是假定主题对象知道观察者需要的数据;而拉模型是主题对象不知道观察者具体需要什么数据,
 * 没有办法的情况下,干脆把自身传递给观察者,让观察者自己去按需取值;
 * 2.推模型肯能会使得观察者难以复用,因为观察者的update()方法是按需要定义的参数,
 * 可能无法兼顾没有考虑到的使用情况,就可能提供新的update()方法,或者干脆重新实现观察者;
 * 而拉模型就不会造成这样的情况,因为拉模型下,update()方法的参数是主题对象本身,
 * 这基本上是主题对象能传递的最大数据集合了,基本可以适应各种情况的需要;
 */

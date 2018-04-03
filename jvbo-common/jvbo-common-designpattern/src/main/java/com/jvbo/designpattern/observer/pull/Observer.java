/*
 * Observer.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.observer.pull;

/**
 * 抽象观察者角色
 * @ClassName: Observer 
 * @Description: 为所有的具体观察者定义一个接口,在得到主题的通知时更新自己,
 * 这个接口叫做更新接口;
 * @author jvbo
 * @date 2017年11月10日
 */
public interface Observer {

	void update(Subject subject);

}

/*
 * Component.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.composite.transparent;

import java.util.List;

/**
 * 抽象构建角色
 * @ClassName: Component 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public abstract class Component {
	//输出组件自身名称
	public abstract void printStruct(String preStr);
	
	//增加一个子组件对象
	public void addChild(Component child){
		//缺省实现,没有此功能
		throw new UnsupportedOperationException("对象不支持此功能");
	}
	
	//删除一个子组件对象
	public void removeChild(int index){
		//缺省实现,没有此功能
		throw new UnsupportedOperationException("对象不支持此功能");
	}
	
	//获取所有子构建对象
	public List<Component> getChild(){
		//缺省实现,没有此功能
		throw new UnsupportedOperationException("对象不支持此功能");
	}
	
}

/*
 * Composite.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.composite.safe;

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝构建角色
 * @ClassName: Composite 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class Composite implements Component {
	
	//用来存储组合对象中包含的子组件对象
	private List<Component> childComponents = new ArrayList<Component>();
	//组合对象的名字
	private String name;
	
	public Composite(String name){
		this.name = name;
	}
	
	//聚集管理方法,增加一个子组件对象
	public void addChild(Component child){
		childComponents.add(child);
	}
	
	//聚集管理方法,删除一个子组件对象
	public void removeChild(int index){
		childComponents.remove(index);
	}
	
	//聚集管理方法,获取所有子组件对象
	public List<Component> getChild(){
        return childComponents;
    }
	
	//输出对象的自身结构
	@Override
	public void printStruct(String preStr) {
		System.out.println(preStr + "+" + this.name);
		//若还包含子组件,输出
		if(this.childComponents != null){
			preStr += "  ";
			for (Component component : childComponents) {
				component.printStruct(preStr);
			}
		}
	}

}

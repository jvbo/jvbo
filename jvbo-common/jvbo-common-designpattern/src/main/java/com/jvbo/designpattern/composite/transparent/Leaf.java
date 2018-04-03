/*
 * Leaf.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.composite.transparent;

/**
 * 树叶构建角色
 * @ClassName: Leaf 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class Leaf extends Component {
	
	private String name;
	
	public Leaf(String name){
		this.name = name;
	}

	@Override
	public void printStruct(String preStr) {
		System.out.println(preStr + "-" + name);
	}
	
}

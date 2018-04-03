/*
 * ObjectStructure.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.eg;

import java.util.ArrayList;
import java.util.List;

/**
 * 结构对象角色
 * @ClassName: ObjectStructure 
 * @Description: 可以遍历结构中的所有元素;
 * 如果需要,提供一个高层次的接口让访问者对象可以访问每一个元素;
 * 如果需要,可以设计成一个复合对象或者一个聚集,如List或Set;
 * @author jvbo
 * @date 2017年11月13日
 */
public class ObjectStructure {
	private List<Node> nodes = new ArrayList<Node>();
	
	//执行方法操作
	public void action(Visitor visitor){
        for(Node node : nodes){
            node.accept(visitor);
        }
    }
	
	//添加一个新元素
	public void add(Node node){
        nodes.add(node);
    }
}

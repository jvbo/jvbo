/*
 * ConcreteAggregate.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.iterator.egone;

/**
 * 具体聚集角色
 * @ClassName: ConcreteAggregate 
 * @Description: 实现创建迭代子(Iterator)对象的接口,返回一个合适的具体迭代子实例;
 * @author jvbo
 * @date 2017年11月10日
 */
public class ConcreteAggregate extends Aggregate {
	
	private Object[] objArray = null;
	
	public ConcreteAggregate(Object[] objArray){
		this.objArray = objArray;
	}

	@Override
	public Iterator createIterator() {
		return new ConcreteIterator(this);
	}
	
	//取值方法:向外界提供聚集元素
	public Object getElement(int index){
        if(index < objArray.length){
            return objArray[index];
        }else{
            return null;
        }
    }
	
	//取值方法:向外界提供聚集的大小
	public int size(){
        return objArray.length;
    }

}

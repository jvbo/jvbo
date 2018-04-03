/*
 * ConcreteIterator.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.iterator.egone;

/**
 * 具体迭代子角色
 * @ClassName: ConcreteIterator 
 * @Description: 实现了Iterator接口,并保持迭代过程中的游标位置;
 * @author jvbo
 * @date 2017年11月10日
 */
public class ConcreteIterator implements Iterator {
	//持有被迭代的具体的聚合对象
	private ConcreteAggregate agg;
	//内部索引,记录当前迭代到的索引位置
	private int index = 0;
	//记录当前聚集对象的大小
	private int size = 0;

	public ConcreteIterator(ConcreteAggregate agg) {
		this.agg = agg;
		this.size = agg.size();
		index = 0;
	}

	@Override
	public void frist() {
		index = 0;
	}

	@Override
	public void next() {
		if(index < size){
			index ++;
		}
	}

	@Override
	public boolean isDone() {
		return (index >= size);
	}

	@Override
	public Object currentItem() {
		return agg.getElement(index);
	}

}

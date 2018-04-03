/*
 * ConcreteAggregate.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.iterator.egtwo;

/**
 * 具体聚集角色类
 * @ClassName: ConcreteAggregate 
 * @Description: 实现了抽象聚集角色所要求的接口,也就是createIterator()方法;
 * 此外,聚集类有一个内部成员类ConcreteIterator,这个内部类实现了抽象迭代子角色所规定的接口;
 * 而工厂方法createIterator()所返还的就是这个内部成员类的实例;
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
		return new ConcreteIterator();
	}
	
	/**
	 * 内部成员类,具体迭代子类
	 * @ClassName: ConcreteIterator 
	 * @Description: TODO
	 * @author jvbo
	 * @date 2017年11月10日
	 */
	private class ConcreteIterator implements Iterator{
		private int index = 0;
		private int size = 0;
		
		public ConcreteIterator(){
			this.size = objArray.length;
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
			return objArray[index];
		}
	}

}

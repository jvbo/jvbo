/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.iterator.egone;

/**
 * 迭代子模式-白箱聚集与外禀迭代子-客户端类
 * @ClassName: Client 
 * @Description: 迭代子模式又叫游标(Cursor)模式,是对象的行为模式,
 * 迭代子模式可以顺序地访问一个聚集中的元素而不必暴露聚集的内部表象(internal representation)
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	/**
	 * 白箱聚集与外禀迭代子
	 * 
	 * 白箱聚集:
	 * 如果一个聚集的接口提供了可以用来修改聚集元素的方法,这个接口就是所谓的宽接口;
	 * 如果聚集对象为所有对象提供同一个接口,也就是宽接口的话,当然会满足迭代子模式对迭代子对象的要求;
	 * 但是,这样会破坏对聚集对象的封装;
	 * 这种提供宽接口的聚集叫做白箱聚集,聚集对象向外界提供同样的宽接口;
	 * 
	 * 外禀迭代子:
	 * 由于聚集自己实现迭代逻辑,并向外部提供适当的接口,使得迭代子可以从外部控制聚集元素的迭代过程;
	 * 这样一来迭代子所控制的仅仅是一个游标而已,这种迭代子叫做游标迭代子(Cursor Iterator);
	 * 由于迭代子是在聚集结构之外的,因此这样的迭代子又叫做外禀迭代子(Extrinsic Iterator);
	 */
	
	/**
	 * 首先创建了一个聚集类实例,
	 * 然后调用聚集对象的工厂方法createIterator()以得到一个迭代子对象;
	 * 在得到迭代子的实例后,客户端开始迭代过程,打印出所有的聚集元素;
	 */
	public void operation(){
		Object[] objArray = {"One","Two","Three","Four","Five","Six"};
		//创建聚合对象
        Aggregate agg = new ConcreteAggregate(objArray);
        //循环输出聚合对象中的值
        Iterator it = agg.createIterator();
        while(!it.isDone()){
            System.out.println(it.currentItem());
            it.next();
        }
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.operation();
	}
}

/*
 * Client.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.eg;

/**
 * 访问者模式-客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Client {
	public static void main(String[] args) {
		//创建一个结构对象
        ObjectStructure os = new ObjectStructure();
        //给结构增加一个节点
        os.add(new ConcreteNodeA());
        //给结构增加一个节点
        os.add(new ConcreteNodeB());
        //创建一个访问者
        Visitor visitor = new ConcreteVisitorA();
        os.action(visitor);
	}
}

/**
 * 访问者模式优点:
 * 1.好的扩展性:能够在不修改对象结构中的元素的情况下,为对象结构中的元素添加新的功能;
 * 2.好的复用性:可以通过访问者来定义整个对象结构通用的功能,从而提高复用程度;
 * 3.分离无关行为:可以通过访问者来分离无关的行为,把相关的行为封装在一起,构成一个访问者,
 * 这样每一个访问者的功能都比较单一;
 * 
 * 访问者模式缺点:
 * 1.对象结构变化困难:不适用于对象结构中的类经常变化的情况,因为对象结构发生了改变,
 * 访问者的接口和访问者的实现都要发生相应的改变,代价太高;
 * 2.破坏封装:访问者模式通常需要对象结构开放内部数据给访问者和ObjectStructrue,
 * 这破坏了对象的封装性;
 */

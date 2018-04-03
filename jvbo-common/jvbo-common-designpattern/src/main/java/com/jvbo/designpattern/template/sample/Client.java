/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.template.sample;

/**
 * 模板方法模式-客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	/**
	 * 模板模式的关键是:子类可以置换掉父类的可变部分,但是子类却不可以改变模板方法所代表的顶级逻辑;
	 * 
	 * 模板方法中的方法:
	 * 1.模板方法:
	 * a.一个模板方法是定义在抽象类中的,把基本操作方法组合在一起形成一个总算法或一个总行为的方法;
	 * b.一个抽象类可以有任意多个模板方法,而不限于一个,每一个模板方法都可以调用任意多个具体方法;
	 * 
	 * 2.基本方法
	 * a.抽象方法:一个抽象方法由抽象类声明,由具体子类实现,在Java语言里抽象方法以abstract关键字标示;
	 * b.具体方法:一个具体方法由抽象类声明并实现,而子类并不实现或置换;
	 * c.钩子方法:一个钩子方法由抽象类声明并实现,而子类会加以扩展,通常抽象类给出的实现是一个空实现,作为方法的默认实现;
	 * 
	 * 3.默认钩子方法
	 * 钩子方法常常由抽象类给出一个空实现作为此方法的默认实现,这种空的钩子方法叫做"Do Nothing Hook",
	 * 这种默认钩子方法在缺省适配模式里面已经见过了,一个缺省适配模式讲的是一个类为一个接口提供一个默认的空实现,
	 * 从而使得缺省适配类的子类不必像实现接口那样必须给出所有方法的实现,因为通常一个具体类并不需要所有的方法;
	 * 
	 * 4.命名规则
	 * a.命名规则是设计师之间赖以沟通的管道之一,使用恰当的命名规则可以帮助不同设计师之间的沟通;
	 * b.钩子方法的名字应当以do开始,这是熟悉设计模式的Java开发人员的标准做法,
	 * 在HttpServlet类中,也遵从这一命名规则,如doGet(),doPost()等方法;
	 */
	
	public static void main(String[] args) {
		
	}
}
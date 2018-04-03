/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.flyweight.complex;

import java.util.ArrayList;
import java.util.List;

/**
 * 享元模式-客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	
	/**
	 * 内蕴状态:是存储在享元对象内部,并且是不会随环境的改变而有所不同,
	 * 故一个享元可以具有内蕴状态并可以共享;
	 * 
	 * 外蕴状态:随环境的改变而改变,不可以共享,享元对象的外蕴状态必须有客户端保存,
	 * 并在享元对象被创建之后,在需要使用的时候再传入到享元对象内部,
	 * 外蕴状态不可以影响享元对象的内蕴状态,他们是互相独立的;
	 */
	
	public static void main(String[] args) {
		List<Character> compositeState = new ArrayList<Character>();
		compositeState.add('a');
		compositeState.add('b');
		compositeState.add('c');
		compositeState.add('a');
		compositeState.add('b');
		
		FlyweightFactory flyFactory = new FlyweightFactory();
		Flyweight compositeFly1 = flyFactory.factory(compositeState);
		Flyweight compositeFly2 = flyFactory.factory(compositeState);
		compositeFly1.operation("composite call");
		
		System.out.println("----");
		
		System.out.println("复合享元模式是否可以共享对象:" + (compositeFly1 == compositeFly2));
		
		Character state = 'a';
		Flyweight fly1 = flyFactory.factory(state);
		Flyweight fly2 = flyFactory.factory(state);
		System.out.println("单纯享元模式是否可以共享独享:" + (fly1 == fly2));
	}
	
}

/**
 * 享元模式优点:大幅度降低内存中对象的数量;
 * 享元模式缺点:使得系统更加复杂,为了使对象可以共享,需要将一些状态外部化,这使得程序逻辑复杂化;
 * 将享元对象的状态外部化,而读取外部状态使得运行时间稍微变长;
 */

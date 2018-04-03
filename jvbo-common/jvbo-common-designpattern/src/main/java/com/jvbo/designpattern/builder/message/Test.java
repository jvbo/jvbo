/*
 * Test.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.message;

/**
 * 建造模式-测试类()
 * @ClassName: Test 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public class Test {
	/**
	 * 假设有一个电子杂志系统，定期地向用户的电子邮件信箱发送电子杂志。
	 * 用户可以通过网页订阅电子杂志，也可以通过网页结束订阅。
	 * 当客户开始订阅时，系统发送一个电子邮件表示欢迎，当客户结束订阅时，
	 * 系统发送一个电子邮件表示欢送。本例子就是这个系统负责发送“欢迎”和“欢送”邮件的模块。
	 * 在本例中，产品类就是发给某个客户的“欢迎”和“欢送”邮件
	 */
	
	public static void main(String[] args) {
		Builder builder = new WelcomeBuilder();
		Director director = new Director(builder);
		director.construct("to@gmail.com", "form@gmail.com");
	}
	
}

/**
 * 建造模式两个重要部分：
 * 1.Builder接口，定义了如何构建各个部件，知道每个部件如何实现，以及如何装配到产品中去；
 * 2.Director，Director知道如何组合来构建产品，即Director负责整体的构建算法，
 * 而且通常分步骤来执行；
 * 
 * 总结：无论如何变化，建造模式都存在这么两个部分，一个部分是部件构造和产品装配，
 * 另一个部分是整体构建的算法；建造模式的重心在于分离构建算法和具体的构造实现，
 * 从而使得构建算法可以重用。具体的构造实现可以很方便的扩展和切换，从而可以灵活的组合来构造出不同的产品对象；
 * 
 **/

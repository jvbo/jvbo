/*
 * Test.java 2017年10月31日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.factorymethod;

/**
 * 工厂方法模式-测试类
 * @ClassName: Test 
 * @Description: TODO
 * @author jvbo
 * @date 2017年10月31日
 */
public class Test {
	/**
	 * 1.抽象工厂角色(ExportFactory):任何在模式中创建对象的工厂类必须实现此接口，实际中常用抽象类实现
	 * 2.具体工厂角色(ExportHtmlFactory,ExportPdfFactory):事项抽象工厂接口的具体java类，
	 * 其中含有与业务密切相关的逻辑，被使用者调用以创建导出类(如ExportStandardHtmlFile);
	 * 3.抽象导出角色(ExportFile):工厂方法模式所创建的对象的超类，即所有导出类的共同父类或公共拥有的接口，
	 * 实际使用中常常使用抽象类实现；
	 * 4.具体导出角色(ExportStandardHtmlFile):实现了抽象导出角色(ExportFile)所声明的接口，
	 * 工厂方法模式创建的每一个对象都是某个具体导出角色的实例；
	 */
	
	public static void main(String[] args) {
		String data = "";
		ExportFactory factory = new ExportHtmlFactory();
		ExportFile file = factory.factory("financial");
		file.export(data);
	}
}

/**
 * 工厂方法模式和简单工厂模式
 * 1. 结构不同，工厂方法模式核心是一个抽象工厂类，简单工厂模式是一个具体类
 * 2.
 **/

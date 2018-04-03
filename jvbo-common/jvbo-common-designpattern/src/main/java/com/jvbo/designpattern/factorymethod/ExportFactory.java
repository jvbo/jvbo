/*
 * ExportFactory.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.factorymethod;

/**
 * 抽象工厂角色
 * @ClassName: ExportFactory 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public interface ExportFactory {
	ExportFile factory(String type);
}

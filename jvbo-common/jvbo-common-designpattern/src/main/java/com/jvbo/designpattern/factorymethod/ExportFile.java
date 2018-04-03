/*
 * ExportFile.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.factorymethod;

/**
 * 抽象导出角色类
 * @ClassName: ExportFile 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public interface ExportFile {
	boolean export(String data);
}

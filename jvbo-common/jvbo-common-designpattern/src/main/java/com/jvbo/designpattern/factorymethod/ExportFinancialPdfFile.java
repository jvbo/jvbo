/*
 * ExportFinancialPdfFile.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.factorymethod;

public class ExportFinancialPdfFile implements ExportFile {

	@Override
	public boolean export(String data) {
		System.out.println("导出财务版pdf文件");
		return true;
	}

}

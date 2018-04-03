/*
 * ExportPdfFactory.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.factorymethod;

public class ExportPdfFactory implements ExportFactory {

	@Override
	public ExportFile factory(String type) {
		if("standard".equals(type)){
			return new ExportStandardPdfFile();
		}else if("financial".equals(type)){
			return new ExportFinancialPdfFile();
		}else{
			throw new RuntimeException("类型有误");
		}
	}

}

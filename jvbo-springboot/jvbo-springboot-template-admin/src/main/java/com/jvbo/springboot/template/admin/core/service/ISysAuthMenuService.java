/*
 * ISysAuthMenuService.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.service;

import java.util.List;

import com.jvbo.springboot.template.admin.core.model.AuthMenu;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

public interface ISysAuthMenuService {
	boolean save(AuthMenu record);
	boolean update(AuthMenu record);
	AuthMenu findById(String id);
	boolean batchFalseDel(String[]ids);
	List<AuthMenu> list(AuthMenu params);
	long count(AuthMenu params);
	DataGrid<AuthMenu> dataGridList(AuthMenu params, Page page);
	
	
	List<AuthMenu> findByIdList(List<String> idList);
	
}

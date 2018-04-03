/*
 * ISysAuthRoleMenuService.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.service;

import java.util.List;

import com.jvbo.springboot.template.admin.core.model.AuthRoleMenu;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

public interface ISysAuthRoleMenuService {
	boolean save(AuthRoleMenu record);
	boolean update(AuthRoleMenu record);
	AuthRoleMenu findById(String id);
	boolean batchFalseDel(String[]ids);
	List<AuthRoleMenu> list(AuthRoleMenu params);
	long count(AuthRoleMenu params);
	DataGrid<AuthRoleMenu> dataGridList(AuthRoleMenu params, Page page);
	
	
	List<AuthRoleMenu> findByRoleIdList(List<String> roleIdList);
	
}

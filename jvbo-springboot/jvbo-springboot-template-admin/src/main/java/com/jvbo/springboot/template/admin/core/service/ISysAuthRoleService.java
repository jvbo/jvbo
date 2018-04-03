/*
 * ISysAuthRoleService.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.service;

import java.util.List;

import com.jvbo.springboot.template.admin.core.model.AuthRole;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

public interface ISysAuthRoleService {
	boolean save(AuthRole record);
	boolean update(AuthRole record);
	AuthRole findById(String id);
	boolean batchFalseDel(String[]ids);
	List<AuthRole> list(AuthRole params);
	long count(AuthRole params);
	DataGrid<AuthRole> dataGridList(AuthRole params, Page page);
	
}

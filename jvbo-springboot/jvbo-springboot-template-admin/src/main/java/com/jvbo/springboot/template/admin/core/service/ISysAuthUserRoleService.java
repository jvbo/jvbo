/*
 * ISysAuthUserRoleService.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.service;

import java.util.List;

import com.jvbo.springboot.template.admin.core.model.AuthUserRole;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

public interface ISysAuthUserRoleService {
	boolean save(AuthUserRole record);
	boolean update(AuthUserRole record);
	AuthUserRole findById(String id);
	boolean batchFalseDel(String[]ids);
	List<AuthUserRole> list(AuthUserRole params);
	long count(AuthUserRole params);
	DataGrid<AuthUserRole> dataGridList(AuthUserRole params, Page page);
	
	
	List<AuthUserRole> findUserRoleTree(String userId);
	boolean saveUserRoleTree(List<AuthUserRole> userRoleList);
	boolean delFalseByUserId(String userId);
	
}

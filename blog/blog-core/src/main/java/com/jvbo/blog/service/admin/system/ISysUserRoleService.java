/*
 * IUserRoleService.java 2016年10月26日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.admin.system;

import java.util.List;

import com.jvbo.blog.model.UserRole;
import com.jvbo.blog.model.SysUserRole;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

public interface ISysUserRoleService {
	
	boolean save(UserRole record);
	boolean update(UserRole record);
	UserRole findById(String id);
	boolean batchDel(String[]ids);
	
	long count(String userId);
	DataGrid<UserRole> list(String userId, Page page);
	
	List<UserRole> findByUserId(String userId);
	List<SysUserRole> findUserRoleTree(String userId);
	boolean delFalseByUserId(String userId);
	boolean saveUserRoleTree(List<UserRole> userRoleList);
}

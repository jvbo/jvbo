/*
 * IRoleService.java 2016年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.admin.system;

import com.jvbo.blog.model.Role;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

public interface ISysRoleService {
	
	boolean save(Role record);
	boolean update(Role record);
	Role findById(String id);
	boolean batchDel(String[]ids);
	
	long count(String roleName);
	DataGrid<Role> list(String roleName, Page page);
}

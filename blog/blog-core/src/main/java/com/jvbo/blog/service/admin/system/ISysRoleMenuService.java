/*
 * IRoleMenuService.java 2016年10月26日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.admin.system;

import java.util.List;
import java.util.Map;

import com.jvbo.blog.model.RoleMenu;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

public interface ISysRoleMenuService {
	
	boolean save(RoleMenu record);
	boolean update(RoleMenu record);
	RoleMenu findById(String id);
	boolean batchDel(String[]ids);
	
	long count(String roleId);
	DataGrid<RoleMenu> list(String roleId, Page page);
	
	List<RoleMenu> findByRoleIdList(List<String> roleIdList);
	List<Map<String, Object>> findRoleMenuTree(Map<String, Object> mapParams);
	boolean delFalseByRoleId(String roleId);
	boolean saveRoleMenuTree(List<RoleMenu> roleMenuList);

}

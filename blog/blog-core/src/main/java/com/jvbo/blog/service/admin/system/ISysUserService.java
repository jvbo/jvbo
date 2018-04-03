/*
 * IUserService.java 2016年10月25日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.admin.system;

import com.jvbo.blog.model.User;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

public interface ISysUserService {
	
	boolean save(User record);
	boolean update(User record);
	User findById(String id);
	boolean batchDel(String[]ids);
	
	long count(String loginName);
	DataGrid<User> list(String loginName, Page page);
	
	User findByLoginName(String loginName);
}

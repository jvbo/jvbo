/*
 * ISysUserService.java 2017年7月28日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.service;

import java.util.List;
import java.util.Map;

import com.jvbo.springboot.template.admin.core.model.SysUser;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

public interface ISysUserService {
	boolean save(SysUser record);
	boolean update(SysUser record);
	//boolean batchFalseDel(String[]ids); //无删除标识字段
	SysUser findById(String id);
	long count(Map<String, Object> params);
	DataGrid<SysUser> dataGridList(Map<String, Object> params, Page page);
	List<SysUser> listByMap(Map<String, Object> params);
	
	
}

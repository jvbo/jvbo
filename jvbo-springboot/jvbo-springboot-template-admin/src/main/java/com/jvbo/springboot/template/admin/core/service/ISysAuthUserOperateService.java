/*
 * ISysAuthUserOperateService.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.service;

import java.util.List;

import com.jvbo.springboot.template.admin.core.model.AuthUserOperate;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

public interface ISysAuthUserOperateService {
	boolean save(AuthUserOperate record);
	boolean update(AuthUserOperate record);
	AuthUserOperate findById(String id);
	boolean batchFalseDel(String[]ids);
	List<AuthUserOperate> list(AuthUserOperate params);
	long count(AuthUserOperate params);
	DataGrid<AuthUserOperate> dataGridList(AuthUserOperate params, Page page);
	
}

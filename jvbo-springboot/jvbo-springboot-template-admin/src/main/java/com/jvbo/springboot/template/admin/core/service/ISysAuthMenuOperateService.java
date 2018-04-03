/*
 * ISysAuthMenuOperateService.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.service;

import java.util.List;

import com.jvbo.springboot.template.admin.core.model.AuthMenuOperate;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

public interface ISysAuthMenuOperateService {
	boolean save(AuthMenuOperate record);
	boolean update(AuthMenuOperate record);
	AuthMenuOperate findById(String id);
	boolean batchFalseDel(String[]ids);
	List<AuthMenuOperate> list(AuthMenuOperate params);
	long count(AuthMenuOperate params);
	DataGrid<AuthMenuOperate> dataGridList(AuthMenuOperate params, Page page);
	
}

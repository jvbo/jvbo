/*
 * ISysAuthOperateService.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.service;

import java.util.List;

import com.jvbo.springboot.template.admin.core.model.AuthOperate;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

public interface ISysAuthOperateService {
	boolean save(AuthOperate record);
	boolean update(AuthOperate record);
	AuthOperate findById(String id);
	boolean batchFalseDel(String[]ids);
	List<AuthOperate> list(AuthOperate params);
	long count(AuthOperate params);
	DataGrid<AuthOperate> dataGridList(AuthOperate params, Page page);
	
}

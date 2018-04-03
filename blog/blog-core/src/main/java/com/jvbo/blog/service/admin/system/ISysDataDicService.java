/*
 * IDataDicService.java 2016年10月22日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.admin.system;

import com.jvbo.blog.model.DataDic;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

public interface ISysDataDicService {

	boolean save(DataDic record);
	boolean update(DataDic record);
	DataDic findById(String id);
	boolean batchDel(String[]ids);
	
	long count(String dataKey);
	DataGrid<DataDic> list(String dataKey, Page page);

}

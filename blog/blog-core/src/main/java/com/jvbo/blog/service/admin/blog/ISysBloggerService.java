/*
 * IBloggerService.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: IBloggerService.java
 * @Package com.jvbo.blog.service.admin.blog
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
package com.jvbo.blog.service.admin.blog;

import com.jvbo.blog.model.Blogger;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

/**  
 * @ClassName: IBloggerService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
public interface ISysBloggerService {
	boolean save(Blogger record);
	boolean update(Blogger record);
	Blogger findById(String id);
	boolean batchDel(String[]ids);
	
	long count(String userName);
	DataGrid<Blogger> list(String userName, Page page);
}

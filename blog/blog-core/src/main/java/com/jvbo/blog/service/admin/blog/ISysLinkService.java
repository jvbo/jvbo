/*
 * ILinkService.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: ILinkService.java
 * @Package com.jvbo.blog.service.admin.blog
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
package com.jvbo.blog.service.admin.blog;

import com.jvbo.blog.model.Link;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

/**  
 * @ClassName: ILinkService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
public interface ISysLinkService {
	boolean save(Link record);
	boolean update(Link record);
	Link findById(String id);
	boolean batchDel(String[]ids);
	
	long count(String linkName);
	DataGrid<Link> list(String linkName, Page page);
}

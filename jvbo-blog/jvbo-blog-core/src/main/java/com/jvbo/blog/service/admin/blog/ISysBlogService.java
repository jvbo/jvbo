/*
 * IBlogService.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: IBlogService.java
 * @Package com.jvbo.blog.service.admin.blog
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
package com.jvbo.blog.service.admin.blog;

import com.jvbo.blog.bo.BlogBo;
import com.jvbo.blog.model.SysBlogBlogType;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

/**  
 * @ClassName: IBlogService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
public interface ISysBlogService {
	boolean save(BlogBo blogBo);
	boolean update(BlogBo blogBo);
	SysBlogBlogType findById(String id);
	boolean batchDel(String[]ids);
	
	long count(String title);
	DataGrid<SysBlogBlogType> list(String title, Page page);
}

/*
 * IBlogTypeService.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: IBlogTypeService.java
 * @Package com.jvbo.blog.service.admin.blog
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
package com.jvbo.blog.service.admin.blog;

import java.util.List;

import com.jvbo.blog.model.BlogType;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

/**  
 * @ClassName: IBlogTypeService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
public interface ISysBlogTypeService {
	boolean save(BlogType record);
	boolean update(BlogType record);
	BlogType findById(String id);
	boolean batchDel(String[]ids);
	
	long count(String typeName);
	DataGrid<BlogType> list(String typeName, Page page);
	List<BlogType> findBlogTypeList();
}

/*
 * ICommentService.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: ICommentService.java
 * @Package com.jvbo.blog.service.admin.blog
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
package com.jvbo.blog.service.admin.blog;

import com.jvbo.blog.model.Comment;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

/**  
 * @ClassName: ICommentService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
public interface ISysCommentService {
	boolean save(Comment record);
	boolean update(Comment record);
	Comment findById(String id);
	boolean batchDel(String[]ids);
	
	long count(String content);
	DataGrid<Comment> list(String content, Page page);
}

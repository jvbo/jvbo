/*
 * IMenuService.java 2016年10月26日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: IMenuService.java
 * @Package com.jvbo.blog.service.admin.system
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月26日
 */
package com.jvbo.blog.service.admin.system;

import java.util.List;

import com.jvbo.blog.model.Menu;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

/**  
 * @ClassName: IMenuService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月26日
 */
public interface ISysMenuService {

	boolean save(Menu record);
	boolean update(Menu record);
	Menu findById(String id);
	boolean batchDel(String[]ids);
	
	long count(String name);
	DataGrid<Menu> list(String name, Page page);
	
	List<Menu> findByIds(List<String> menuIdList);
	List<Menu> findParentMenuList();
	
}

/*
 * SysMenuRoleMapper.java 2016年11月3日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.dao.admin;

import java.util.List;
import java.util.Map;

import com.jvbo.blog.model.SysRoleMenu;

public interface SysRoleMenuMapper {
	
	List<SysRoleMenu> selectMenuTreeByRoleId(Map<String, Object> mapParams);
}

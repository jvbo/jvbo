/*
 * RoleService.java 2016年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.admin.system.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jvbo.blog.dao.admin.RoleMapper;
import com.jvbo.blog.model.Role;
import com.jvbo.blog.model.RoleExample;
import com.jvbo.blog.service.admin.system.ISysRoleService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

@Service
public class SysRoleService implements ISysRoleService {
	
	@Autowired
	private RoleMapper roleDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean save(Role record) {
		return roleDao.insertSelective(record)>0;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean update(Role record) {
		return roleDao.updateByPrimaryKey(record)>0;
	}

	@Override
	public Role findById(String id) {
		return roleDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchDel(String[] ids) {
		boolean flag = true;
		for (String string : ids) {
			flag = roleDao.deleteByPrimaryKey(string)>0;
			if(!flag){
				break;
			}
		}
		return flag;
	}

	@Override
	public long count(String roleName) {
		RoleExample example = new RoleExample();
		RoleExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(roleName)){
			criteria.andNameEqualTo(roleName);
		}
		return roleDao.countByExample(example);
	}

	@Override
	public DataGrid<Role> list(String roleName, Page page) {
		RoleExample example = new RoleExample();
		RoleExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(roleName)){
			criteria.andNameEqualTo(roleName);
		}
		page.setTotalRecords(Long.valueOf(count(roleName)).intValue());
		example.setPage(page);
		List<Role> roleList = roleDao.selectByExample(example);
		DataGrid<Role> dg = new DataGrid<Role>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(roleList);
		dg.setPage(page.getPage());
		return dg;
	}

}

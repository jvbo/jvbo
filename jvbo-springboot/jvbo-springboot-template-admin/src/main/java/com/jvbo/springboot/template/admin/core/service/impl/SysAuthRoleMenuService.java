/*
 * SysAuthRoleMenuService.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jvbo.springboot.template.admin.core.mapper.AuthRoleMenuMapper;
import com.jvbo.springboot.template.admin.core.model.AuthRoleMenu;
import com.jvbo.springboot.template.admin.core.model.AuthRoleMenuExample;
import com.jvbo.springboot.template.admin.core.service.ISysAuthRoleMenuService;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

@Service
public class SysAuthRoleMenuService implements ISysAuthRoleMenuService {
	
	@Autowired
	private AuthRoleMenuMapper authRoleMenuDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(AuthRoleMenu record) {
		return authRoleMenuDao.insertSelective(record)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(AuthRoleMenu record) {
		return authRoleMenuDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public AuthRoleMenu findById(String id) {
		return authRoleMenuDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchFalseDel(String[] ids) {
		boolean flag = true;
		AuthRoleMenu record = null;
		for (String string : ids) {
			record = new AuthRoleMenu();
			record.setId(string);
			record.setGmtModified(System.currentTimeMillis());
			record.setIsDeleted(1);
			flag = authRoleMenuDao.updateByPrimaryKeySelective(record) > 0;
			if(!flag){
				break;
			}
		}
		/*if(!flag){
			throw new RuntimeException();
		}*/
		if(!flag){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return flag;
	}
	
	@Override
	public List<AuthRoleMenu> list(AuthRoleMenu params) {
		AuthRoleMenuExample example = new AuthRoleMenuExample();
		AuthRoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getRoleId())){
				criteria.andRoleIdEqualTo(params.getRoleId());
			}
			if(StringUtils.isNotBlank(params.getMenuId())){
				criteria.andMenuIdEqualTo(params.getMenuId());
			}
		}
		List<AuthRoleMenu> authRoleMenuList = authRoleMenuDao.selectByExample(example);
		return authRoleMenuList;
	}

	@Override
	public long count(AuthRoleMenu params) {
		AuthRoleMenuExample example = new AuthRoleMenuExample();
		AuthRoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getRoleId())){
				criteria.andRoleIdEqualTo(params.getRoleId());
			}
			if(StringUtils.isNotBlank(params.getMenuId())){
				criteria.andMenuIdEqualTo(params.getMenuId());
			}
		}
		return authRoleMenuDao.countByExample(example);
	}

	@Override
	public DataGrid<AuthRoleMenu> dataGridList(AuthRoleMenu params, Page page) {
		AuthRoleMenuExample example = new AuthRoleMenuExample();
		AuthRoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getRoleId())){
				criteria.andRoleIdEqualTo(params.getRoleId());
			}
			if(StringUtils.isNotBlank(params.getMenuId())){
				criteria.andMenuIdEqualTo(params.getMenuId());
			}
		}
		page.setTotalRecords(Long.valueOf(count(params)).intValue());
		example.setPage(page);
		List<AuthRoleMenu> authRoleMenuList = authRoleMenuDao.selectByExample(example);
		DataGrid<AuthRoleMenu> dg = new DataGrid<AuthRoleMenu>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(authRoleMenuList);
		dg.setPage(page.getPage());
		return dg;
	}
	
	
	

	@Override
	public List<AuthRoleMenu> findByRoleIdList(List<String> roleIdList) {
		AuthRoleMenuExample example = new AuthRoleMenuExample();
		AuthRoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		criteria.andRoleIdIn(roleIdList);
		return authRoleMenuDao.selectByExample(example);
	}

}

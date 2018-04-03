/*
 * SysAuthRoleService.java 2017年8月29日
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

import com.jvbo.springboot.template.admin.core.mapper.AuthRoleMapper;
import com.jvbo.springboot.template.admin.core.model.AuthRole;
import com.jvbo.springboot.template.admin.core.model.AuthRoleExample;
import com.jvbo.springboot.template.admin.core.service.ISysAuthRoleService;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

@Service
public class SysAuthRoleService implements ISysAuthRoleService {
	
	@Autowired
	private AuthRoleMapper authRoleDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(AuthRole record) {
		return authRoleDao.insertSelective(record)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(AuthRole record) {
		return authRoleDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public AuthRole findById(String id) {
		return authRoleDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchFalseDel(String[] ids) {
		boolean flag = true;
		AuthRole record = null;
		for (String string : ids) {
			record = new AuthRole();
			record.setId(string);
			record.setGmtModified(System.currentTimeMillis());
			record.setIsDeleted(1);
			flag = authRoleDao.updateByPrimaryKeySelective(record) > 0;
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
	public List<AuthRole> list(AuthRole params) {
		AuthRoleExample example = new AuthRoleExample();
		AuthRoleExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getName())){
				criteria.andNameEqualTo(params.getName());
			}
		}
		List<AuthRole> authRoleList = authRoleDao.selectByExample(example);
		return authRoleList;
	}

	@Override
	public long count(AuthRole params) {
		AuthRoleExample example = new AuthRoleExample();
		AuthRoleExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getName())){
				criteria.andNameEqualTo(params.getName());
			}
		}
		return authRoleDao.countByExample(example);
	}

	@Override
	public DataGrid<AuthRole> dataGridList(AuthRole params, Page page) {
		AuthRoleExample example = new AuthRoleExample();
		AuthRoleExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getName())){
				criteria.andNameEqualTo(params.getName());
			}
		}
		page.setTotalRecords(Long.valueOf(count(params)).intValue());
		example.setPage(page);
		List<AuthRole> authRoleList = authRoleDao.selectByExample(example);
		DataGrid<AuthRole> dg = new DataGrid<AuthRole>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(authRoleList);
		dg.setPage(page.getPage());
		return dg;
	}

}

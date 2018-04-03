/*
 * SysAuthMenuService.java 2017年8月29日
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

import com.jvbo.springboot.template.admin.core.mapper.AuthMenuMapper;
import com.jvbo.springboot.template.admin.core.model.AuthMenu;
import com.jvbo.springboot.template.admin.core.model.AuthMenuExample;
import com.jvbo.springboot.template.admin.core.service.ISysAuthMenuService;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

@Service
public class SysAuthMenuService implements ISysAuthMenuService {
	
	@Autowired
	private AuthMenuMapper authMenuDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(AuthMenu record) {
		return authMenuDao.insertSelective(record)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(AuthMenu record) {
		return authMenuDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public AuthMenu findById(String id) {
		return authMenuDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchFalseDel(String[] ids) {
		boolean flag = true;
		AuthMenu record = null;
		for (String string : ids) {
			record = new AuthMenu();
			record.setId(string);
			record.setGmtModified(System.currentTimeMillis());
			record.setIsDeleted(1);
			flag = authMenuDao.updateByPrimaryKeySelective(record) > 0;
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
	public List<AuthMenu> list(AuthMenu params) {
		AuthMenuExample example = new AuthMenuExample();
		AuthMenuExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getName())){
				criteria.andNameEqualTo(params.getName());
			}
		}
		List<AuthMenu> authMenuList = authMenuDao.selectByExample(example);
		return authMenuList;
	}

	@Override
	public long count(AuthMenu params) {
		AuthMenuExample example = new AuthMenuExample();
		AuthMenuExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getName())){
				criteria.andNameEqualTo(params.getName());
			}
		}
		return authMenuDao.countByExample(example);
	}

	@Override
	public DataGrid<AuthMenu> dataGridList(AuthMenu params, Page page) {
		AuthMenuExample example = new AuthMenuExample();
		AuthMenuExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getName())){
				criteria.andNameEqualTo(params.getName());
			}
		}
		page.setTotalRecords(Long.valueOf(count(params)).intValue());
		example.setPage(page);
		List<AuthMenu> authMenuList = authMenuDao.selectByExample(example);
		DataGrid<AuthMenu> dg = new DataGrid<AuthMenu>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(authMenuList);
		dg.setPage(page.getPage());
		return dg;
	}
	
	
	

	@Override
	public List<AuthMenu> findByIdList(List<String> idList) {
		AuthMenuExample example = new AuthMenuExample();
		AuthMenuExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(idList);
		return authMenuDao.selectByExample(example);
	}

}

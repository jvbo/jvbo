/*
 * SysAuthOperateService.java 2017年8月29日
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

import com.jvbo.springboot.template.admin.core.mapper.AuthOperateMapper;
import com.jvbo.springboot.template.admin.core.model.AuthOperate;
import com.jvbo.springboot.template.admin.core.model.AuthOperateExample;
import com.jvbo.springboot.template.admin.core.service.ISysAuthOperateService;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

@Service
public class SysAuthOperateService implements ISysAuthOperateService {
	
	@Autowired
	private AuthOperateMapper authOperateDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(AuthOperate record) {
		return authOperateDao.insertSelective(record)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(AuthOperate record) {
		return authOperateDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public AuthOperate findById(String id) {
		return authOperateDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchFalseDel(String[] ids) {
		boolean flag = true;
		AuthOperate record = null;
		for (String string : ids) {
			record = new AuthOperate();
			record.setId(string);
			record.setGmtModified(System.currentTimeMillis());
			record.setIsDeleted(1);
			flag = authOperateDao.updateByPrimaryKeySelective(record) > 0;
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
	public List<AuthOperate> list(AuthOperate params) {
		AuthOperateExample example = new AuthOperateExample();
		AuthOperateExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getName())){
				criteria.andNameEqualTo(params.getName());
			}
		}
		List<AuthOperate> authOperateList = authOperateDao.selectByExample(example);
		return authOperateList;
	}

	@Override
	public long count(AuthOperate params) {
		AuthOperateExample example = new AuthOperateExample();
		AuthOperateExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getName())){
				criteria.andNameEqualTo(params.getName());
			}
		}
		return authOperateDao.countByExample(example);
	}

	@Override
	public DataGrid<AuthOperate> dataGridList(AuthOperate params, Page page) {
		AuthOperateExample example = new AuthOperateExample();
		AuthOperateExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getName())){
				criteria.andNameEqualTo(params.getName());
			}
		}
		page.setTotalRecords(Long.valueOf(count(params)).intValue());
		example.setPage(page);
		List<AuthOperate> authOperateList = authOperateDao.selectByExample(example);
		DataGrid<AuthOperate> dg = new DataGrid<AuthOperate>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(authOperateList);
		dg.setPage(page.getPage());
		return dg;
	}

}

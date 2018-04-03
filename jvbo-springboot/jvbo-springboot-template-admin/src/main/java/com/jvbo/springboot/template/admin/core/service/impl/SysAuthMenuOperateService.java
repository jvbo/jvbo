/*
 * SysAuthMenuOperateService.java 2017年8月29日
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

import com.jvbo.springboot.template.admin.core.mapper.AuthMenuOperateMapper;
import com.jvbo.springboot.template.admin.core.model.AuthMenuOperate;
import com.jvbo.springboot.template.admin.core.model.AuthMenuOperateExample;
import com.jvbo.springboot.template.admin.core.service.ISysAuthMenuOperateService;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

@Service
public class SysAuthMenuOperateService implements ISysAuthMenuOperateService {
	
	@Autowired
	private AuthMenuOperateMapper authMenuOperateDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(AuthMenuOperate record) {
		return authMenuOperateDao.insertSelective(record)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(AuthMenuOperate record) {
		return authMenuOperateDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public AuthMenuOperate findById(String id) {
		return authMenuOperateDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchFalseDel(String[] ids) {
		boolean flag = true;
		AuthMenuOperate record = null;
		for (String string : ids) {
			record = new AuthMenuOperate();
			record.setId(string);
			record.setGmtModified(System.currentTimeMillis());
			record.setIsDeleted(1);
			flag = authMenuOperateDao.updateByPrimaryKeySelective(record) > 0;
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
	public List<AuthMenuOperate> list(AuthMenuOperate params) {
		AuthMenuOperateExample example = new AuthMenuOperateExample();
		AuthMenuOperateExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getOperateId())){
				criteria.andOperateIdEqualTo(params.getOperateId());
			}
			if(StringUtils.isNotBlank(params.getMenuId())){
				criteria.andOperateIdEqualTo(params.getMenuId());
			}
		}
		List<AuthMenuOperate> authMenuOperateList = authMenuOperateDao.selectByExample(example);
		return authMenuOperateList;
	}

	@Override
	public long count(AuthMenuOperate params) {
		AuthMenuOperateExample example = new AuthMenuOperateExample();
		AuthMenuOperateExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getOperateId())){
				criteria.andOperateIdEqualTo(params.getOperateId());
			}
			if(StringUtils.isNotBlank(params.getMenuId())){
				criteria.andOperateIdEqualTo(params.getMenuId());
			}
		}
		return authMenuOperateDao.countByExample(example);
	}

	@Override
	public DataGrid<AuthMenuOperate> dataGridList(AuthMenuOperate params, Page page) {
		AuthMenuOperateExample example = new AuthMenuOperateExample();
		AuthMenuOperateExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getOperateId())){
				criteria.andOperateIdEqualTo(params.getOperateId());
			}
			if(StringUtils.isNotBlank(params.getMenuId())){
				criteria.andOperateIdEqualTo(params.getMenuId());
			}
		}
		page.setTotalRecords(Long.valueOf(count(params)).intValue());
		example.setPage(page);
		List<AuthMenuOperate> authMenuOperateList = authMenuOperateDao.selectByExample(example);
		DataGrid<AuthMenuOperate> dg = new DataGrid<AuthMenuOperate>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(authMenuOperateList);
		dg.setPage(page.getPage());
		return dg;
	}

}

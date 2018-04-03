/*
 * SysAuthUserOperateService.java 2017年8月29日
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

import com.jvbo.springboot.template.admin.core.mapper.AuthUserOperateMapper;
import com.jvbo.springboot.template.admin.core.model.AuthUserOperate;
import com.jvbo.springboot.template.admin.core.model.AuthUserOperateExample;
import com.jvbo.springboot.template.admin.core.service.ISysAuthUserOperateService;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

@Service
public class SysAuthUserOperateService implements ISysAuthUserOperateService {
	
	@Autowired
	private AuthUserOperateMapper authUserOperateDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(AuthUserOperate record) {
		return authUserOperateDao.insertSelective(record)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(AuthUserOperate record) {
		return authUserOperateDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public AuthUserOperate findById(String id) {
		return authUserOperateDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchFalseDel(String[] ids) {
		boolean flag = true;
		AuthUserOperate record = null;
		for (String string : ids) {
			record = new AuthUserOperate();
			record.setId(string);
			record.setGmtModified(System.currentTimeMillis());
			record.setIsDeleted(1);
			flag = authUserOperateDao.updateByPrimaryKeySelective(record) > 0;
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
	public List<AuthUserOperate> list(AuthUserOperate params) {
		AuthUserOperateExample example = new AuthUserOperateExample();
		AuthUserOperateExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getUserId())){
				criteria.andUserIdEqualTo(params.getUserId());
			}
			if(StringUtils.isNotBlank(params.getOperateId())){
				criteria.andOperateIdEqualTo(params.getOperateId());
			}
		}
		List<AuthUserOperate> authUserOperateList = authUserOperateDao.selectByExample(example);
		return authUserOperateList;
	}

	@Override
	public long count(AuthUserOperate params) {
		AuthUserOperateExample example = new AuthUserOperateExample();
		AuthUserOperateExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getUserId())){
				criteria.andUserIdEqualTo(params.getUserId());
			}
			if(StringUtils.isNotBlank(params.getOperateId())){
				criteria.andOperateIdEqualTo(params.getOperateId());
			}
		}
		return authUserOperateDao.countByExample(example);
	}

	@Override
	public DataGrid<AuthUserOperate> dataGridList(AuthUserOperate params, Page page) {
		AuthUserOperateExample example = new AuthUserOperateExample();
		AuthUserOperateExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getUserId())){
				criteria.andUserIdEqualTo(params.getUserId());
			}
			if(StringUtils.isNotBlank(params.getOperateId())){
				criteria.andOperateIdEqualTo(params.getOperateId());
			}
		}
		page.setTotalRecords(Long.valueOf(count(params)).intValue());
		example.setPage(page);
		List<AuthUserOperate> authUserOperateList = authUserOperateDao.selectByExample(example);
		DataGrid<AuthUserOperate> dg = new DataGrid<AuthUserOperate>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(authUserOperateList);
		dg.setPage(page.getPage());
		return dg;
	}

}

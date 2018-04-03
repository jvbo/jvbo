/*
 * SysUserService.java 2017年7月28日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jvbo.springboot.template.admin.core.mapper.SysUserMapper;
import com.jvbo.springboot.template.admin.core.model.SysUser;
import com.jvbo.springboot.template.admin.core.model.SysUserExample;
import com.jvbo.springboot.template.admin.core.service.ISysUserService;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

@Service
public class SysUserService implements ISysUserService {
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean save(SysUser record) {
		return userMapper.insertSelective(record) > 0;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean update(SysUser record) {
		return userMapper.updateByPrimaryKeySelective(record) > 0;
	}

	/*@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean batchFalseDel(String[] ids) {
		boolean flag = true;
		SysUser record = null;
		for (String string : ids) {
			record = new SysUser();
			record.setId(string);
			record.setUpdateDate(System.currentTimeMillis());
			record.setEnabled(1);
			flag = userMapper.updateByPrimaryKeySelective(record) > 0;
			if(!flag){
				break;
			}
		}
		if(!flag){
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new RuntimeException();
		}
		return flag;
	}*/

	@Override
	public SysUser findById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public long count(Map<String, Object> params) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		if(MapUtils.isNotEmpty(params)){
			if(params.containsKey("username")){
				criteria.andUsernameEqualTo(params.get("username").toString());
			}
		}
		return userMapper.countByExample(example);
	}

	@Override
	public DataGrid<SysUser> dataGridList(Map<String, Object> params, Page page) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		if(MapUtils.isNotEmpty(params)){
			if(params.containsKey("username")){
				criteria.andUsernameEqualTo(params.get("username").toString());
			}
		}
		page.setTotalRecords(Long.valueOf(count(params)).intValue());
		example.setPage(page);
		List<SysUser> userList = userMapper.selectByExample(example);
		DataGrid<SysUser> dg = new DataGrid<SysUser>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(userList);
		dg.setPage(page.getPage());
		return dg;
	}

	@Override
	public List<SysUser> listByMap(Map<String, Object> params) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		if(MapUtils.isNotEmpty(params)){
			if(params.containsKey("username")){
				criteria.andUsernameEqualTo(params.get("username").toString());
			}
		}
		return userMapper.selectByExample(example);
	}
	
}

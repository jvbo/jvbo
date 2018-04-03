/*
 * UserService.java 2016年10月25日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.admin.system.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jvbo.blog.dao.admin.UserMapper;
import com.jvbo.blog.model.User;
import com.jvbo.blog.model.UserExample;
import com.jvbo.blog.service.admin.system.ISysUserService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

@Service
public class SysUserService implements ISysUserService {
	
	@Autowired
	private UserMapper userDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(User record) {
		return userDao.insertSelective(record)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(User record) {
		return userDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public User findById(String id) {
		return userDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchDel(String[] ids) {
		boolean flag = true;
		for (String string : ids) {
			flag = userDao.deleteByPrimaryKey(string)>0;
			if(!flag){
				break;
			}
		}
		return flag;
	}

	@Override
	public long count(String loginName) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(loginName)){
			criteria.andLoginNameEqualTo(loginName);
		}
		return userDao.countByExample(example);
	}

	@Override
	public DataGrid<User> list(String loginName, Page page) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(loginName)){
			criteria.andLoginNameEqualTo(loginName);
		}
		page.setTotalRecords(Long.valueOf(count(loginName)).intValue());
		example.setPage(page);
		List<User> userList = userDao.selectByExample(example);
		DataGrid<User> dg = new DataGrid<User>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(userList);
		dg.setPage(page.getPage());
		return dg;
	}
	
	@Override
	public User findByLoginName(String loginName){
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		criteria.andLoginNameEqualTo(loginName);
		List<User> userList = userDao.selectByExample(example);
		if(CollectionUtils.isNotEmpty(userList)){
			return userList.get(0);
		}else{
			return null;
		}
	}

}

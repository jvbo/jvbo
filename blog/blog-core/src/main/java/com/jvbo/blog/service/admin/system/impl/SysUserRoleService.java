/*
 * UserRoleService.java 2016年10月26日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.admin.system.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jvbo.blog.model.UserRole;
import com.jvbo.blog.model.UserRoleExample;
import com.jvbo.blog.service.admin.system.ISysUserRoleService;
import com.jvbo.blog.dao.admin.SysUserRoleMapper;
import com.jvbo.blog.dao.admin.UserRoleMapper;
import com.jvbo.blog.model.SysUserRole;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

@Service
public class SysUserRoleService implements ISysUserRoleService {
	
	@Autowired
	private UserRoleMapper userRoleDao;
	@Autowired
	private SysUserRoleMapper sysUserRoleDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(UserRole record) {
		return userRoleDao.insertSelective(record)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(UserRole record) {
		return userRoleDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public UserRole findById(String id) {
		return userRoleDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchDel(String[] ids) {
		boolean flag = true;
		for (String string : ids) {
			flag = userRoleDao.deleteByPrimaryKey(string)>0;
			if(!flag){
				break;
			}
		}
		return flag;
	}

	@Override
	public long count(String userId) {
		UserRoleExample example = new UserRoleExample();
		UserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(userId)){
			criteria.andUserIdEqualTo(userId);
		}
		return userRoleDao.countByExample(example);
	}

	@Override
	public DataGrid<UserRole> list(String userId, Page page) {
		UserRoleExample example = new UserRoleExample();
		UserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(userId)){
			criteria.andUserIdEqualTo(userId);
		}
		page.setTotalRecords(Long.valueOf(count(userId)).intValue());
		example.setPage(page);
		List<UserRole> userRoleList = userRoleDao.selectByExample(example);
		DataGrid<UserRole> dg = new DataGrid<UserRole>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(userRoleList);
		dg.setPage(page.getPage());
		return dg;
	}

	@Override
	public List<UserRole> findByUserId(String userId) {
		UserRoleExample example = new UserRoleExample();
		UserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		criteria.andUserIdEqualTo(userId);
		return userRoleDao.selectByExample(example);
	}

	@Override
	public List<SysUserRole> findUserRoleTree(String userId) {
		return sysUserRoleDao.selectRoleTreeByUserId(userId);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean delFalseByUserId(String userId) {
		UserRoleExample example = new UserRoleExample();
		UserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		UserRole userRole = new UserRole();
		userRole.setDelFlag("0");
		return userRoleDao.updateByExampleSelective(userRole, example)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean saveUserRoleTree(List<UserRole> userRoleList) {
		UserRoleExample example = new UserRoleExample();
		UserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userRoleList.get(0).getUserId());
		UserRole updUserRole = new UserRole();
		updUserRole.setDelFlag("0");
		int iRet = userRoleDao.updateByExampleSelective(updUserRole, example);
		boolean flag = true;
		if(iRet>=0){
			for (UserRole userRole : userRoleList) {
				flag = userRoleDao.insertSelective(userRole)>0;
				if(!flag){
					break;
				}
			}
		}
		if(!flag){
			throw new RuntimeException();
		}
		return flag;
	}
	
}

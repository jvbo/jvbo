/*
 * RoleMenuService.java 2016年10月26日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.admin.system.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jvbo.blog.dao.admin.RoleMenuMapper;
import com.jvbo.blog.dao.admin.SysRoleMenuMapper;
import com.jvbo.blog.model.RoleMenu;
import com.jvbo.blog.model.RoleMenuExample;
import com.jvbo.blog.model.SysRoleMenu;
import com.jvbo.blog.service.admin.system.ISysRoleMenuService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

@Service
public class SysRoleMenuService implements ISysRoleMenuService {
	
	@Autowired
	private RoleMenuMapper roleMenuDao;
	@Autowired
	private SysRoleMenuMapper sysRoleMenuDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(RoleMenu record) {
		return roleMenuDao.insertSelective(record)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(RoleMenu record) {
		return roleMenuDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public RoleMenu findById(String id) {
		return roleMenuDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchDel(String[] ids) {
		boolean flag = true;
		for (String string : ids) {
			flag = roleMenuDao.deleteByPrimaryKey(string)>0;
			if(!flag){
				break;
			}
		}
		return flag;
	}
	
	@Override
	public long count(String roleId) {
		RoleMenuExample example = new RoleMenuExample();
		RoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(roleId)){
			criteria.andRoleIdEqualTo(roleId);
		}
		return roleMenuDao.countByExample(example);
	}

	@Override
	public DataGrid<RoleMenu> list(String roleId, Page page) {
		RoleMenuExample example = new RoleMenuExample();
		RoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(roleId)){
			criteria.andRoleIdEqualTo(roleId);
		}
		page.setTotalRecords(Long.valueOf(count(roleId)).intValue());
		example.setPage(page);
		List<RoleMenu> roleMenuList = roleMenuDao.selectByExample(example);
		DataGrid<RoleMenu> dg = new DataGrid<RoleMenu>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(roleMenuList);
		dg.setPage(page.getPage());
		return dg;
	}

	@Override
	public List<RoleMenu> findByRoleIdList(List<String> roleIdList) {
		RoleMenuExample example = new RoleMenuExample();
		RoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		criteria.andRoleIdIn(roleIdList);
		return roleMenuDao.selectByExample(example);
	}

	@Override
	public List<Map<String, Object>> findRoleMenuTree(Map<String, Object> mapParams) {
		List<SysRoleMenu> sysRoleMenuList = sysRoleMenuDao.selectMenuTreeByRoleId(mapParams);
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		for(SysRoleMenu vo:sysRoleMenuList){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", vo.getId());
			map.put("text", vo.getName());
			map.put("state", vo.getState());
			map.put("checked", vo.getChecked());
			data.add(map);
		}
		return data;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean delFalseByRoleId(String roleId) {
		RoleMenuExample example = new RoleMenuExample();
		RoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		RoleMenu roleMenu = new RoleMenu();
		roleMenu.setDelFlag("0");
		return roleMenuDao.updateByExampleSelective(roleMenu, example)>0;
	}

	@Override
	public boolean saveRoleMenuTree(List<RoleMenu> roleMenuList) {
		RoleMenuExample example = new RoleMenuExample();
		RoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleMenuList.get(0).getRoleId());
		RoleMenu updRoleMenu = new RoleMenu();
		updRoleMenu.setDelFlag("0");
		int iRet = roleMenuDao.updateByExampleSelective(updRoleMenu, example);
		boolean flag = true;
		if(iRet>=0){
			for (RoleMenu roleMenu : roleMenuList) {
				flag = roleMenuDao.insertSelective(roleMenu)>0;
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

/*
 * MenuService.java 2016年10月26日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.admin.system.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jvbo.blog.dao.admin.MenuMapper;
import com.jvbo.blog.model.Menu;
import com.jvbo.blog.model.MenuExample;
import com.jvbo.blog.service.admin.system.ISysMenuService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

@Service
public class SysMenuService implements ISysMenuService {
	
	@Autowired
	private MenuMapper menuDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(Menu record) {
		return menuDao.insertSelective(record)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(Menu record) {
		return menuDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public Menu findById(String id) {
		return menuDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchDel(String[] ids) {
		boolean flag = true;
		for (String string : ids) {
			flag = menuDao.deleteByPrimaryKey(string)>0;
			if(!flag){
				break;
			}
		}
		return flag;
	}

	@Override
	public long count(String name) {
		MenuExample example = new MenuExample();
		MenuExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(name)){
			criteria.andNameEqualTo(name);
		}
		return menuDao.countByExample(example);
	}

	@Override
	public DataGrid<Menu> list(String name, Page page) {
		MenuExample example = new MenuExample();
		MenuExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(name)){
			criteria.andNameEqualTo(name);
		}
		page.setTotalRecords(Long.valueOf(count(name)).intValue());
		example.setPage(page);
		List<Menu> menuList = menuDao.selectByExample(example);
		DataGrid<Menu> dg = new DataGrid<Menu>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(menuList);
		dg.setPage(page.getPage());
		return dg;
	}

	@Override
	public List<Menu> findByIds(List<String> menuIdList) {
		MenuExample example = new MenuExample();
		MenuExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(menuIdList);
		return menuDao.selectByExample(example);
	}

	@Override
	public List<Menu> findParentMenuList() {
		MenuExample example = new MenuExample();
		MenuExample.Criteria criteria = example.createCriteria();
		criteria.andParentMenuEqualTo("0");
		return menuDao.selectByExample(example);
	}
	
}

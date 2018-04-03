/*
 * LinkService.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: LinkService.java
 * @Package com.jvbo.blog.service.admin.blog.impl
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
package com.jvbo.blog.service.admin.blog.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jvbo.blog.dao.admin.LinkMapper;
import com.jvbo.blog.model.Link;
import com.jvbo.blog.model.LinkExample;
import com.jvbo.blog.service.admin.blog.ISysLinkService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

/**  
 * @ClassName: LinkService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
@Service
public class SysLinkService implements ISysLinkService {
	
	@Autowired
	private LinkMapper linkDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(Link record) {
		return linkDao.insertSelective(record)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(Link record) {
		return linkDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public Link findById(String id) {
		return linkDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchDel(String[] ids) {
		boolean flag = true;
		for (String string : ids) {
			flag = linkDao.deleteByPrimaryKey(string)>0;
			if(!flag){
				break;
			}
		}
		return flag;
	}

	@Override
	public long count(String linkName) {
		LinkExample example = new LinkExample();
		LinkExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(linkName)){
			criteria.andLinkNameEqualTo(linkName);
		}
		return linkDao.countByExample(example);
	}

	@Override
	public DataGrid<Link> list(String linkName, Page page) {
		LinkExample example = new LinkExample();
		LinkExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(linkName)){
			criteria.andLinkNameEqualTo(linkName);
		}
		page.setTotalRecords(Long.valueOf(count(linkName)).intValue());
		example.setPage(page);
		List<Link> linkList = linkDao.selectByExample(example);
		DataGrid<Link> dg = new DataGrid<Link>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(linkList);
		dg.setPage(page.getPage());
		return dg;
	}

}

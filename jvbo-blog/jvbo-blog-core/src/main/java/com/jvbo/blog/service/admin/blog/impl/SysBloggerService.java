/*
 * BloggerService.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: BloggerService.java
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

import com.jvbo.blog.dao.admin.BloggerMapper;
import com.jvbo.blog.model.Blogger;
import com.jvbo.blog.model.BloggerExample;
import com.jvbo.blog.service.admin.blog.ISysBloggerService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

/**  
 * @ClassName: BloggerService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
@Service
public class SysBloggerService implements ISysBloggerService {
	
	@Autowired
	private BloggerMapper bloggerDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean save(Blogger record) {
		return bloggerDao.insertSelective(record)>0;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean update(Blogger record) {
		return bloggerDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public Blogger findById(String id) {
		return bloggerDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean batchDel(String[] ids) {
		boolean flag = true;
		for (String string : ids) {
			flag = bloggerDao.deleteByPrimaryKey(string)>0;
			if(!flag){
				break;
			}
		}
		return flag;
	}

	@Override
	public long count(String userName) {
		BloggerExample example = new BloggerExample();
		BloggerExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(userName)){
			criteria.andUserNameEqualTo(userName);
		}
		return bloggerDao.countByExample(example);
	}

	@Override
	public DataGrid<Blogger> list(String userName, Page page) {
		BloggerExample example = new BloggerExample();
		BloggerExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(userName)){
			criteria.andUserNameEqualTo(userName);
		}
		page.setTotalRecords(Long.valueOf(count(userName)).intValue());
		example.setPage(page);
		List<Blogger> bloggerList = bloggerDao.selectByExample(example);
		DataGrid<Blogger> dg = new DataGrid<Blogger>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(bloggerList);
		dg.setPage(page.getPage());
		return dg;
	}

}

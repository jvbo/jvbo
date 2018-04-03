/*
 * BlogTypeService.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: BlogTypeService.java
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

import com.jvbo.blog.dao.admin.BlogTypeMapper;
import com.jvbo.blog.model.BlogType;
import com.jvbo.blog.model.BlogTypeExample;
import com.jvbo.blog.service.admin.blog.ISysBlogTypeService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

/**  
 * @ClassName: BlogTypeService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
@Service
public class SysBlogTypeService implements ISysBlogTypeService {
	
	@Autowired
	private BlogTypeMapper blogTypeDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean save(BlogType record) {
		return blogTypeDao.insertSelective(record)>0;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean update(BlogType record) {
		return blogTypeDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public BlogType findById(String id) {
		return blogTypeDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean batchDel(String[] ids) {
		boolean flag = true;
		for (String string : ids) {
			flag = blogTypeDao.deleteByPrimaryKey(string)>0;
			if(!flag){
				break;
			}
		}
		return flag;
	}

	@Override
	public long count(String typeName) {
		BlogTypeExample example = new BlogTypeExample();
		BlogTypeExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(typeName)){
			criteria.andTypeNameEqualTo(typeName);
		}
		return blogTypeDao.countByExample(example);
	}

	@Override
	public DataGrid<BlogType> list(String typeName, Page page) {
		BlogTypeExample example = new BlogTypeExample();
		BlogTypeExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(typeName)){
			criteria.andTypeNameEqualTo(typeName);
		}
		page.setTotalRecords(Long.valueOf(count(typeName)).intValue());
		example.setPage(page);
		List<BlogType> blogTypeList = blogTypeDao.selectByExample(example);
		DataGrid<BlogType> dg = new DataGrid<BlogType>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(blogTypeList);
		dg.setPage(page.getPage());
		return dg;
	}

	@Override
	public List<BlogType> findBlogTypeList() {
		BlogTypeExample example = new BlogTypeExample();
		BlogTypeExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		return blogTypeDao.selectByExample(example);
	}

}

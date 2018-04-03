/*
 * DataDicService.java 2016年10月22日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.admin.system.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jvbo.blog.dao.admin.DataDicMapper;
import com.jvbo.blog.model.DataDic;
import com.jvbo.blog.model.DataDicExample;
import com.jvbo.blog.service.admin.system.ISysDataDicService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

@Service
public class SysDataDicService implements ISysDataDicService {
	
	@Autowired
	private DataDicMapper dataDicDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(DataDic record) {
		return dataDicDao.insertSelective(record)>0;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(DataDic record) {
		return dataDicDao.updateByPrimaryKeySelective(record)>0;
	}
	
	@Override
	public DataDic findById(String id) {
		return dataDicDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchDel(String[] ids) {
		boolean flag = true;
		for (String string : ids) {
			flag = dataDicDao.deleteByPrimaryKey(string)>0;
			if(!flag){
				break;
			}
		}
		return flag;
	}

	@Override
	public long count(String dataKey) {
		DataDicExample example = new DataDicExample();
		DataDicExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(dataKey)){
			criteria.andDicKeyEqualTo(dataKey);
		}
		return dataDicDao.countByExample(example);
	}

	@Override
	public DataGrid<DataDic> list(String dataKey, Page page) {
		DataDicExample example = new DataDicExample();
		DataDicExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(dataKey)){
			criteria.andDicKeyEqualTo(dataKey);
		}
		page.setTotalRecords(Long.valueOf(count(dataKey)).intValue());
		example.setPage(page);
		List<DataDic> dataDicList = dataDicDao.selectByExample(example);
		DataGrid<DataDic> dg = new DataGrid<DataDic>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(dataDicList);
		dg.setPage(page.getPage());
		return dg;
	}

}

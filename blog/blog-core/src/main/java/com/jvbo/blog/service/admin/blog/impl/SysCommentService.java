/*
 * CommentService.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: CommentService.java
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

import com.jvbo.blog.dao.admin.CommentMapper;
import com.jvbo.blog.model.Comment;
import com.jvbo.blog.model.CommentExample;
import com.jvbo.blog.service.admin.blog.ISysCommentService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

/**  
 * @ClassName: CommentService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
@Service
public class SysCommentService implements ISysCommentService {
	
	@Autowired
	private CommentMapper commentDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean save(Comment record) {
		return commentDao.insertSelective(record)>0;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean update(Comment record) {
		return commentDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public Comment findById(String id) {
		return commentDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean batchDel(String[] ids) {
		boolean flag = true;
		for (String string : ids) {
			flag = commentDao.deleteByPrimaryKey(string)>0;
			if(!flag){
				break;
			}
		}
		return flag;
	}

	@Override
	public long count(String content) {
		CommentExample example = new CommentExample();
		CommentExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(content)){
			criteria.andContentEqualTo(content);
		}
		return commentDao.countByExample(example);
	}

	@Override
	public DataGrid<Comment> list(String content, Page page) {
		CommentExample example = new CommentExample();
		CommentExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(content)){
			criteria.andContentEqualTo(content);
		}
		page.setTotalRecords(Long.valueOf(count(content)).intValue());
		example.setPage(page);
		List<Comment> commentList = commentDao.selectByExample(example);
		DataGrid<Comment> dg = new DataGrid<Comment>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(commentList);
		dg.setPage(page.getPage());
		return dg;
	}

}

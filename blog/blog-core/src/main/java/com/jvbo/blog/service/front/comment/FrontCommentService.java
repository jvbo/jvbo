/*
 * FrontCommentService.java 2016年11月11日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: FrontCommentService.java
 * @Package com.jvbo.blog.service.front.blogType
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
package com.jvbo.blog.service.front.comment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvbo.blog.bo.CommentBo;
import com.jvbo.blog.dao.front.FrontCommentMapper;

/**  
 * @ClassName: FrontCommentService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
@Service
public class FrontCommentService implements IFrontCommentService {
	
	@Autowired
	private FrontCommentMapper commentDao;
	
	@Override
	public int add(CommentBo comment) {
		return commentDao.add(comment);
	}

	@Override
	public List<CommentBo> list(Map<String, Object> map) {
		return commentDao.list(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return commentDao.getTotal(map);
	}

}

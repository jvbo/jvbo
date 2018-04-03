/*
 * FrontCommentMapper.java 2016年11月11日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: FrontCommentMapper.java
 * @Package com.jvbo.blog.dao.front
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
package com.jvbo.blog.dao.front;

import java.util.List;
import java.util.Map;

import com.jvbo.blog.bo.CommentBo;

/**  
 * @ClassName: FrontCommentMapper 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
public interface FrontCommentMapper {
	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
	public int add(CommentBo comment);
	
	/**
	 * 查找用户评论信息
	 * @param map
	 * @return
	 */
	public List<CommentBo> list(Map<String,Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
}

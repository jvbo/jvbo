/*
 * ICommentService.java 2016年10月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: ICommentService.java
 * @Package com.jvbo.blog.service.comment
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月20日
 */
package com.jvbo.blog.service.front.comment;

import java.util.List;
import java.util.Map;

import com.jvbo.blog.bo.CommentBo;

/**  
 * @ClassName: ICommentService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月20日
 */
public interface IFrontCommentService {
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

/*
 * FrontBlogTypeMapper.java 2016年11月11日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: FrontBlogTypeMapper.java
 * @Package com.jvbo.blog.dao.front
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
package com.jvbo.blog.dao.front;

import java.util.List;
import java.util.Map;

import com.jvbo.blog.bo.BlogTypeBo;
import com.jvbo.blog.model.BlogType;

/**  
 * @ClassName: FrontBlogTypeMapper 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
public interface FrontBlogTypeMapper {
	/**
	 * 查询所有博客类型 以及对应的博客数量
	 * @return
	 */
	public List<BlogTypeBo> countList();
	
	/**
	 * 通过id查询博客类型
	 * @param id
	 * @return
	 */
	public BlogType findById(String id);
	
	/**
	 * 分页查询博客类别信息
	 * @param map
	 * @return
	 */
	public List<BlogType> list(Map<String,Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
}

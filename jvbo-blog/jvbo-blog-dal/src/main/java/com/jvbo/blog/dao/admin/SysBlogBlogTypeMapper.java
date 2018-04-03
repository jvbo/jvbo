/*
 * SysBlogBlogTypeMapper.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: SysBlogBlogTypeMapper.java
 * @Package com.jvbo.blog.dao
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
package com.jvbo.blog.dao.admin;

import java.util.List;

import com.jvbo.blog.model.BlogExample;
import com.jvbo.blog.model.SysBlogBlogType;

/**  
 * @ClassName: SysBlogBlogTypeMapper 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
public interface SysBlogBlogTypeMapper {
	long countByExample(BlogExample example);
	List<SysBlogBlogType> selectByExample(BlogExample example);
	SysBlogBlogType selectByPrimaryKey(String id);
}

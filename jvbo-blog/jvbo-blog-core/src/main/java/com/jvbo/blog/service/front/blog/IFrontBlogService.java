/*
 * IBlogService.java 2016年10月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: IBlogService.java
 * @Package com.jvbo.blog.service.blog
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月20日
 */
package com.jvbo.blog.service.front.blog;

import java.util.List;
import java.util.Map;

import com.jvbo.blog.bo.BlogArchiveBo;
import com.jvbo.blog.bo.BlogBo;

/**  
 * @ClassName: IBlogService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月20日
 */
public interface IFrontBlogService {
	
	/**
	 * 根据日期月份分组查询
	 * @return
	 */
	public List<BlogBo> countList(); 
	
	/**
	 * 分页查询博客
	 * @return
	 */
	public List<BlogBo> list(Map<String,Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * 通过Id查找实体
	 * @param id
	 * @return
	 */
	public BlogBo findById(String id);
	
	public Integer update(BlogBo blog);
	
	/**
	 * 获取上一个博客
	 * @param id
	 * @return
	 */
	public BlogBo getLastBlog(String id);
	
	/**
	 * 获取下一个博客
	 * @param id
	 * @return
	 */
	public BlogBo getNextBlog(String id);
	
	/**
	 * 查询指定的博客类别下的博客数量
	 * @param typeId
	 * @return
	 */
	public Integer getBlogCountByTypeId(String typeId);

	public List<BlogBo> newBlogList();

	public List<BlogArchiveBo> archives();
}

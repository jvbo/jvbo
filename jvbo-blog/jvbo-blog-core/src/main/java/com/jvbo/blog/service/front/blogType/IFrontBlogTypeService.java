/*
 * IBlogTypeService.java 2016年10月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: IBlogTypeService.java
 * @Package com.jvbo.blog.service.blogType
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月20日
 */
package com.jvbo.blog.service.front.blogType;

import java.util.List;
import java.util.Map;

import com.jvbo.blog.bo.BlogTypeBo;
import com.jvbo.blog.model.BlogType;

/**  
 * @ClassName: IBlogTypeService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月20日
 */
public interface IFrontBlogTypeService {
	/**
	 * 查询所有博客类型 以及对应的博客数量
	 * @return
	 */
	public List<BlogTypeBo> countList();
	
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

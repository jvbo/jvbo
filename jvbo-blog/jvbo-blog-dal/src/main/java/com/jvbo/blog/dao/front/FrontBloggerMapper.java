/*
 * FrontBloggerMapper.java 2016年11月11日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: FrontBloggerMapper.java
 * @Package com.jvbo.blog.dao.front
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
package com.jvbo.blog.dao.front;

import com.jvbo.blog.model.Blogger;

/**  
 * @ClassName: FrontBloggerMapper 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
public interface FrontBloggerMapper {
	/**
	 * 查询博主信息
	 * @return
	 */
	public Blogger find();
	
	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);
	
}

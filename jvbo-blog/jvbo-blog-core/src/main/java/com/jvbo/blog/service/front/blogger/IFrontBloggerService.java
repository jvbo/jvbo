/*
 * BloggerService.java 2016年10月16日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.front.blogger;

import com.jvbo.blog.model.Blogger;

public interface IFrontBloggerService {
	
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

/*
 * BloggerService.java 2016年10月16日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.front.blogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvbo.blog.dao.front.FrontBloggerMapper;
import com.jvbo.blog.model.Blogger;

@Service
public class FrontBloggerService implements IFrontBloggerService {
	
	@Autowired
	private FrontBloggerMapper bloggerDao;

	public Blogger find() {
		return bloggerDao.find();
	}

	public Blogger getByUserName(String userName) {
		return bloggerDao.getByUserName(userName);
	}
}

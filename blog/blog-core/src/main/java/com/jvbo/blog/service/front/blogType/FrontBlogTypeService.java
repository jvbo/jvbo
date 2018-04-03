/*
 * FrontBlogTypeService.java 2016年11月11日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: FrontBlogTypeService.java
 * @Package com.jvbo.blog.service.front.blogType
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
package com.jvbo.blog.service.front.blogType;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvbo.blog.bo.BlogTypeBo;
import com.jvbo.blog.dao.front.FrontBlogTypeMapper;
import com.jvbo.blog.model.BlogType;

/**  
 * @ClassName: FrontBlogTypeService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
@Service
public class FrontBlogTypeService implements IFrontBlogTypeService {
	
	@Autowired
	private FrontBlogTypeMapper blogTypeDao;
	
	@Override
	public List<BlogTypeBo> countList() {
		return blogTypeDao.countList();
	}

	@Override
	public List<BlogType> list(Map<String, Object> map) {
		return blogTypeDao.list(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return blogTypeDao.getTotal(map);
	}

}

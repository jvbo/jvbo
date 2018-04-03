/*
 * FrontLinkMapper.java 2016年11月11日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: FrontLinkMapper.java
 * @Package com.jvbo.blog.dao.front
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
package com.jvbo.blog.dao.front;

import java.util.List;
import java.util.Map;

import com.jvbo.blog.model.Link;

/**  
 * @ClassName: FrontLinkMapper 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
public interface FrontLinkMapper {
	/**
	 * 查找友情链接信息
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String,Object> map);	
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
}

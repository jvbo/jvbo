/*
 * ILinkService.java 2016年10月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: ILinkService.java
 * @Package com.jvbo.blog.service.link
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月20日
 */
package com.jvbo.blog.service.front.link;

import java.util.List;
import java.util.Map;

import com.jvbo.blog.model.Link;

/**  
 * @ClassName: ILinkService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月20日
 */
public interface IFrontLinkService {
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

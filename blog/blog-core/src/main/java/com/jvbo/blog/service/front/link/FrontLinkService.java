/*
 * FrontLinkService.java 2016年11月11日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: FrontLinkService.java
 * @Package com.jvbo.blog.service.front.link
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
package com.jvbo.blog.service.front.link;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvbo.blog.dao.front.FrontLinkMapper;
import com.jvbo.blog.model.Link;

/**  
 * @ClassName: FrontLinkService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
@Service
public class FrontLinkService implements IFrontLinkService {
	
	@Autowired
	private FrontLinkMapper linkDao;
	
	@Override
	public List<Link> list(Map<String, Object> map) {
		return linkDao.list(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return linkDao.getTotal(map);
	}

}

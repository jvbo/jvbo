/*
 * IMainService.java 2016年10月26日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: IMainService.java
 * @Package com.jvbo.blog.service.admin.system
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月26日
 */
package com.jvbo.blog.service.admin.system;

import java.util.List;

import com.jvbo.blog.service.admin.system.bo.MenuBo;

/**  
 * @ClassName: IMainService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月26日
 */
public interface ISysMainService {
	
	public List<MenuBo> findMenu(String userId);

}

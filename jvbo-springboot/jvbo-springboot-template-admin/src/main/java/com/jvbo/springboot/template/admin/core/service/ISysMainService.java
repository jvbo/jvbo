/*
 * ISysMainService.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.service;

import java.util.List;

import com.jvbo.springboot.template.admin.core.bo.AuthMenuBo;

/**
 * 
 * @ClassName: ISysMainService 
 * @Description: TODO
 * @author jvbo
 * @date 2017年8月29日
 */
public interface ISysMainService {

	List<AuthMenuBo> findMenu(String userId);

}

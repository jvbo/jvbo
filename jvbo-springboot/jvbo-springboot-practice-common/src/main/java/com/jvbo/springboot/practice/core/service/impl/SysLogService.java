/*
 * SysLogService.java 2018年4月11日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvbo.springboot.practice.core.dao.SysLogDao;
import com.jvbo.springboot.practice.core.model.SysLog;
import com.jvbo.springboot.practice.core.model.SysLogExample;
import com.jvbo.springboot.practice.core.service.ISysLogService;
import com.jvbo.springboot.practice.framework.annotation.BaseService;
import com.jvbo.springboot.practice.framework.base.BaseServiceImpl;

@Service
@BaseService
public class SysLogService extends BaseServiceImpl<SysLogDao, SysLog, SysLogExample> implements ISysLogService {
    
    @Autowired
    protected SysLogDao sysLogDao;
    
    
}

package com.jvbo.springboot.practice.core.service.impl;

import com.jvbo.springboot.practice.framework.annotation.BaseService;
import com.jvbo.springboot.practice.framework.base.BaseServiceImpl;
import com.jvbo.springboot.practice.core.dao.SysLogDao;
import com.jvbo.springboot.practice.core.model.SysLog;
import com.jvbo.springboot.practice.core.model.SysLogExample;
import com.jvbo.springboot.practice.core.service.ISysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SysLogServiceImpl实现
 * @date 2018/5/14
 */
@Service
@BaseService
public class SysLogServiceImpl extends BaseServiceImpl<SysLogDao, SysLog, SysLogExample> implements ISysLogService {

    private static final Logger logger = LoggerFactory.getLogger(SysLogServiceImpl.class);

    @Autowired
    SysLogDao sysLogDao;

}
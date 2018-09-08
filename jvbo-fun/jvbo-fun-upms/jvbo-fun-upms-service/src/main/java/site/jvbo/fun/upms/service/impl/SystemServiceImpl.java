package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.SystemDao;
import site.jvbo.fun.upms.dao.model.System;
import site.jvbo.fun.upms.dao.model.SystemExample;
import site.jvbo.fun.upms.service.ISystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SystemServiceImpl实现
 * @date 2018/9/8
 */
@Service
@BaseService
public class SystemServiceImpl extends BaseServiceImpl<SystemDao, System, SystemExample> implements ISystemService {

    private static final Logger logger = LoggerFactory.getLogger(SystemServiceImpl.class);

    @Autowired
    SystemDao systemDao;

}
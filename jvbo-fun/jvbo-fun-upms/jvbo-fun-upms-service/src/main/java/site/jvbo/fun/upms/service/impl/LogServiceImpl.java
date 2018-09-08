package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.LogDao;
import site.jvbo.fun.upms.dao.model.Log;
import site.jvbo.fun.upms.dao.model.LogExample;
import site.jvbo.fun.upms.service.ILogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LogServiceImpl实现
 * @date 2018/9/8
 */
@Service
@BaseService
public class LogServiceImpl extends BaseServiceImpl<LogDao, Log, LogExample> implements ILogService {

    private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Autowired
    LogDao logDao;

}
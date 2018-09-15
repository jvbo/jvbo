package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.dao.UpmsLogDao;
import site.jvbo.fun.upms.dao.model.UpmsLog;
import site.jvbo.fun.upms.dao.model.UpmsLogExample;
import site.jvbo.fun.upms.service.IUpmsLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UpmsLogServiceImpl实现
 * @date 2018/9/10
 */
@Service
@BaseService
public class UpmsLogServiceImpl extends BaseServiceImpl<UpmsLogDao, UpmsLog, UpmsLogExample> implements IUpmsLogService {
    private static final Logger logger = LoggerFactory.getLogger(UpmsLogServiceImpl.class);

    @Autowired
    UpmsLogDao upmsLogDao;

}
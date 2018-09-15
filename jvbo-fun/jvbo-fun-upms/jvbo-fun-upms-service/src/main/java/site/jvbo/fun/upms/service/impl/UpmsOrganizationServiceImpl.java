package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.dao.UpmsOrganizationDao;
import site.jvbo.fun.upms.dao.model.UpmsOrganization;
import site.jvbo.fun.upms.dao.model.UpmsOrganizationExample;
import site.jvbo.fun.upms.service.IUpmsOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UpmsOrganizationServiceImpl实现
 * @date 2018/9/10
 */
@Service
@BaseService
public class UpmsOrganizationServiceImpl extends BaseServiceImpl<UpmsOrganizationDao, UpmsOrganization, UpmsOrganizationExample> implements IUpmsOrganizationService {
    private static final Logger logger = LoggerFactory.getLogger(UpmsOrganizationServiceImpl.class);

    @Autowired
    UpmsOrganizationDao upmsOrganizationDao;

}
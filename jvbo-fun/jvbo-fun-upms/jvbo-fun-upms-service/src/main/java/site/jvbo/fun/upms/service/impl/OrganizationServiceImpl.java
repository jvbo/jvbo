package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.OrganizationDao;
import site.jvbo.fun.upms.dao.model.Organization;
import site.jvbo.fun.upms.dao.model.OrganizationExample;
import site.jvbo.fun.upms.service.IOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrganizationServiceImpl实现
 * @date 2018/9/8
 */
@Service
@BaseService
public class OrganizationServiceImpl extends BaseServiceImpl<OrganizationDao, Organization, OrganizationExample> implements IOrganizationService {

    private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    @Autowired
    OrganizationDao organizationDao;

}
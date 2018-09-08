package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.UserOrganizationDao;
import site.jvbo.fun.upms.dao.model.UserOrganization;
import site.jvbo.fun.upms.dao.model.UserOrganizationExample;
import site.jvbo.fun.upms.service.IUserOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserOrganizationServiceImpl实现
 * @date 2018/9/8
 */
@Service
@BaseService
public class UserOrganizationServiceImpl extends BaseServiceImpl<UserOrganizationDao, UserOrganization, UserOrganizationExample> implements IUserOrganizationService {

    private static final Logger logger = LoggerFactory.getLogger(UserOrganizationServiceImpl.class);

    @Autowired
    UserOrganizationDao userOrganizationDao;

}
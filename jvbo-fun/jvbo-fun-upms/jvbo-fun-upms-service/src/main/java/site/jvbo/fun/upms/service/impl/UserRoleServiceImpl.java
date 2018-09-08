package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.UserRoleDao;
import site.jvbo.fun.upms.dao.model.UserRole;
import site.jvbo.fun.upms.dao.model.UserRoleExample;
import site.jvbo.fun.upms.service.IUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserRoleServiceImpl实现
 * @date 2018/9/8
 */
@Service
@BaseService
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleDao, UserRole, UserRoleExample> implements IUserRoleService {

    private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Autowired
    UserRoleDao userRoleDao;

}
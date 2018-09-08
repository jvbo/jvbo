package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.UserPermissionDao;
import site.jvbo.fun.upms.dao.model.UserPermission;
import site.jvbo.fun.upms.dao.model.UserPermissionExample;
import site.jvbo.fun.upms.service.IUserPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserPermissionServiceImpl实现
 * @date 2018/9/8
 */
@Service
@BaseService
public class UserPermissionServiceImpl extends BaseServiceImpl<UserPermissionDao, UserPermission, UserPermissionExample> implements IUserPermissionService {

    private static final Logger logger = LoggerFactory.getLogger(UserPermissionServiceImpl.class);

    @Autowired
    UserPermissionDao userPermissionDao;

}
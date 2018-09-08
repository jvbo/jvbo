package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.RolePermissionDao;
import site.jvbo.fun.upms.dao.model.RolePermission;
import site.jvbo.fun.upms.dao.model.RolePermissionExample;
import site.jvbo.fun.upms.service.IRolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RolePermissionServiceImpl实现
 * @date 2018/9/8
 */
@Service
@BaseService
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermissionDao, RolePermission, RolePermissionExample> implements IRolePermissionService {

    private static final Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);

    @Autowired
    RolePermissionDao rolePermissionDao;

}
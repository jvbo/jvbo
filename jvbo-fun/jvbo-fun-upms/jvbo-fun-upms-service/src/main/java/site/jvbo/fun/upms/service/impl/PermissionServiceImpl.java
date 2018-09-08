package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.PermissionDao;
import site.jvbo.fun.upms.dao.model.Permission;
import site.jvbo.fun.upms.dao.model.PermissionExample;
import site.jvbo.fun.upms.service.IPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PermissionServiceImpl实现
 * @date 2018/9/8
 */
@Service
@BaseService
public class PermissionServiceImpl extends BaseServiceImpl<PermissionDao, Permission, PermissionExample> implements IPermissionService {

    private static final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    PermissionDao permissionDao;

}
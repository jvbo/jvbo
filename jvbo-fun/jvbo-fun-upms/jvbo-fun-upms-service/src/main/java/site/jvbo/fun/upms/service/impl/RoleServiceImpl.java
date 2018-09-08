package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.RoleDao;
import site.jvbo.fun.upms.dao.model.Role;
import site.jvbo.fun.upms.dao.model.RoleExample;
import site.jvbo.fun.upms.service.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RoleServiceImpl实现
 * @date 2018/9/8
 */
@Service
@BaseService
public class RoleServiceImpl extends BaseServiceImpl<RoleDao, Role, RoleExample> implements IRoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    RoleDao roleDao;

}
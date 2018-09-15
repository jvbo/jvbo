package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.dao.UpmsRoleDao;
import site.jvbo.fun.upms.dao.model.UpmsRole;
import site.jvbo.fun.upms.dao.model.UpmsRoleExample;
import site.jvbo.fun.upms.service.IUpmsRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UpmsRoleServiceImpl实现
 * @date 2018/9/10
 */
@Service
@BaseService
public class UpmsRoleServiceImpl extends BaseServiceImpl<UpmsRoleDao, UpmsRole, UpmsRoleExample> implements IUpmsRoleService {
    private static final Logger logger = LoggerFactory.getLogger(UpmsRoleServiceImpl.class);

    @Autowired
    UpmsRoleDao upmsRoleDao;

}
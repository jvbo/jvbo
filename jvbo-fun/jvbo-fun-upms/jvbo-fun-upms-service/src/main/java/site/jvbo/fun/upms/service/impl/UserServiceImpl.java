package site.jvbo.fun.upms.service.impl;

import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseServiceImpl;
import site.jvbo.fun.upms.dao.UserDao;
import site.jvbo.fun.upms.dao.model.User;
import site.jvbo.fun.upms.dao.model.UserExample;
import site.jvbo.fun.upms.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl实现
 * @date 2018/9/8
 */
@Service
@BaseService
public class UserServiceImpl extends BaseServiceImpl<UserDao, User, UserExample> implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao userDao;

}
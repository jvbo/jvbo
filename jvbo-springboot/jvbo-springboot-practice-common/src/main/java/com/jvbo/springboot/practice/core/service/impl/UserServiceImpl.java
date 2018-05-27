package com.jvbo.springboot.practice.core.service.impl;

import com.jvbo.springboot.practice.framework.annotation.BaseService;
import com.jvbo.springboot.practice.framework.base.BaseServiceImpl;
import com.jvbo.springboot.practice.core.dao.UserDao;
import com.jvbo.springboot.practice.core.model.User;
import com.jvbo.springboot.practice.core.model.UserExample;
import com.jvbo.springboot.practice.core.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl实现
 * @date 2018/5/14
 */
@Service
@BaseService
public class UserServiceImpl extends BaseServiceImpl<UserDao, User, UserExample> implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao userDao;

}
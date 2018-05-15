package com.jvbo.springboot.practice.core.service.impl;

import com.jvbo.springboot.practice.framework.annotation.BaseService;
import com.jvbo.springboot.practice.framework.base.BaseServiceImpl;
import com.jvbo.springboot.practice.core.dao.UcMemberDao;
import com.jvbo.springboot.practice.core.model.UcMember;
import com.jvbo.springboot.practice.core.model.UcMemberExample;
import com.jvbo.springboot.practice.core.service.IUcMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UcMemberServiceImpl实现
 * @date 2018/5/14
 */
@Service
@BaseService
public class UcMemberServiceImpl extends BaseServiceImpl<UcMemberDao, UcMember, UcMemberExample> implements IUcMemberService {

    private static final Logger logger = LoggerFactory.getLogger(UcMemberServiceImpl.class);

    @Autowired
    UcMemberDao ucMemberDao;

}
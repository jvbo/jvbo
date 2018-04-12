/*
 * UcMemberService.java 2018年4月11日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvbo.springboot.practice.core.dao.UcMemberDao;
import com.jvbo.springboot.practice.core.mapper.UcMemberMapper;
import com.jvbo.springboot.practice.core.model.UcMember;
import com.jvbo.springboot.practice.core.model.UcMemberExample;
import com.jvbo.springboot.practice.core.service.IUcMemberService;
import com.jvbo.springboot.practice.framework.annotation.BaseService;
import com.jvbo.springboot.practice.framework.annotation.ServiceLog;
import com.jvbo.springboot.practice.framework.base.BaseServiceImpl;

@Service
@BaseService
public class UcMemberService extends BaseServiceImpl<UcMemberDao, UcMember, UcMemberExample> implements IUcMemberService {
    
    @Autowired
    protected UcMemberDao ucMemberDao;
    @Autowired
    private UcMemberMapper ucMemberMapper;
    
    @ServiceLog("根据phone查找")
    @Override
    public UcMember findByPhone(String phone) {
        return ucMemberMapper.findByPhone(phone);
    }
}

/*
 * UcMemberDao.java 2018年4月11日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.core.mapper;

import com.jvbo.springboot.practice.core.model.UcMember;

public interface UcMemberMapper {

    UcMember findByPhone(String phone);
    
}

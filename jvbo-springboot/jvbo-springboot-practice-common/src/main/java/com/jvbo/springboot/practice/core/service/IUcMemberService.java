/*
 * IUcMember.java 2018年4月11日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.core.service;

import com.jvbo.springboot.practice.core.model.UcMember;
import com.jvbo.springboot.practice.core.model.UcMemberExample;
import com.jvbo.springboot.practice.framework.base.BaseService;

public interface IUcMemberService extends BaseService<UcMember, UcMemberExample> {
    
    UcMember findByPhone(String phone);
}

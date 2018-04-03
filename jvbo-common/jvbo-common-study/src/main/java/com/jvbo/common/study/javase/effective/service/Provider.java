/*
 * Provider.java 2018年1月29日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.service;

/**
 * service provider insterface
 * @ClassName: Provider 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月29日
 */
public interface Provider {
    
    Service newService();

}

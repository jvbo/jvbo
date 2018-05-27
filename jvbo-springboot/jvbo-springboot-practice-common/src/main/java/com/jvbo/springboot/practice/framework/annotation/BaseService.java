/*
 * BaseService.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.framework.annotation;

import java.lang.annotation.*;

/**
 * 初始化继承BaseService的service
 * @ClassName: BaseService 
 * @Description: TODO
 * @author jvbo
 * @date 2017年8月29日
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseService {
}

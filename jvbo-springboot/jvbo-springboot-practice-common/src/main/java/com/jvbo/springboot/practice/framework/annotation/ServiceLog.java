/*
 * ServiceLog.java 2016年4月21日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLog {
    
    /**
     * 日志操作的描述
     * @Description: TODO
     * @param @return   
     * @return String  
     * @throws
     * @author jvbo
     * @date 2016年4月21日
     */
    String value()  default "";
}

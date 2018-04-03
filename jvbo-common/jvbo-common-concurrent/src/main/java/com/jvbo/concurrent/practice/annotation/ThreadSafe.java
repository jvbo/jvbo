/*
 * ThreadSafe.java 2018年4月1日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 类的线程安全性保证:明确类是线程安全的
 * @ClassName: ThreadSafe 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月1日
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface ThreadSafe {

}

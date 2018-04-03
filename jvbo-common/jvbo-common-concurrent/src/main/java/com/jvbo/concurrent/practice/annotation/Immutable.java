/*
 * Immutable.java 2018年4月1日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 类的注解,线程安全性保证:类是不可变的,包含了@ThreadSafe #ThreadSafe 的含义
 * @ClassName: Immutable 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月1日
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface Immutable {

}

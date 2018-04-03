/*
 * GuardedBy.java 2018年4月1日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 域和方法的注解:标识只有在持有了某个特定的锁时才能访问这个域或者方法,
 * 参数lock标识在访问被标注的域或方法时需要持有的锁;
 * @ClassName: GuardedBy 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月1日
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD })
public @interface GuardedBy {

    String value();

}

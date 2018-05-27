/*
 * Business.java 2018年5月25日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javaee.framework.aop.dcproxy;

/**
 * 代理类
 * @ClassName: Business 
 * @Description: TODO
 * @author jvbo
 * @date 2018年5月25日
 */
public class Business implements IBusiness, IBusiness2 {

    @Override
    public void doThing() {
        System.out.println("do thing");
    }

    @Override
    public void doThing2() {
        System.out.println("do thing2");
    }
}

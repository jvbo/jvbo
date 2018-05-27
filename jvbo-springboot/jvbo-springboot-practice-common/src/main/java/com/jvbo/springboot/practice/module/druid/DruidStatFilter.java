/*
 * DruidStatFilter.java 2017年7月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.module.druid;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
initParams={
    @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
})
public class DruidStatFilter extends WebStatFilter {

}

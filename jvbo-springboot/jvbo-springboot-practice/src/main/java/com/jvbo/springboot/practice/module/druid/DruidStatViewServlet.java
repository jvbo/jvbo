/*
 * DruidStatViewServlet.java 2017年7月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.module.druid;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*",
initParams={
        @WebInitParam(name="allow",value="127.0.0.1"),// IP白名单 (没有配置或者为空，则允许所有访问)
        @WebInitParam(name="deny",value=""),// IP黑名单 (存在共同时，deny优先于allow)
        @WebInitParam(name="loginUsername",value="druid"),// 用户名
        @WebInitParam(name="loginPassword",value="111111"),// 密码
        @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
})
public class DruidStatViewServlet extends StatViewServlet {

}

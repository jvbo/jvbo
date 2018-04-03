/*
 * @(#) initServlet.java 2015年3月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.util.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.jvbo.common.util.os.ToolOS;

/**
 * 系统运行状态相关
 * @Description: TODO
 * @author jv.bo
 * @version 1.0
 * @since 2015-3-12
 */
public class InitServlet implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {}
	
	public void contextInitialized(ServletContextEvent sce) {
		try{
			sce.getServletContext().setAttribute("hostName", ToolOS.getOsLocalHostName());
			sce.getServletContext().setAttribute("userName",ToolOS.getOsSystemProperty(ToolOS.user_name));
			sce.getServletContext().setAttribute("hostIp", ToolOS.getOsLocalHostIp());
			sce.getServletContext().setAttribute("jvmTotalMoney", ToolOS.getJvmTotalMemory() + "M");
			sce.getServletContext().setAttribute("jvmMaxMoney", ToolOS.getJvmMaxMemory() + "M");
			sce.getServletContext().setAttribute("jvmFreeMoney", ToolOS.getJvmFreeMemory() + "M");
			sce.getServletContext().setAttribute("jvmGc", ToolOS.getJvmGcCount());
			sce.getServletContext().setAttribute("javaVersion",ToolOS.getOsSystemProperty(ToolOS.java_version));
			sce.getServletContext().setAttribute("userTmp",ToolOS.getOsSystemProperty(ToolOS.java_io_tmpdir));
			sce.getServletContext().setAttribute("phyTotalMoney", ToolOS.getOsPhysicalMemory()+ "M");
			sce.getServletContext().setAttribute("phyFreeMoney", ToolOS.getOsPhysicalFreeMemory()+ "M");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

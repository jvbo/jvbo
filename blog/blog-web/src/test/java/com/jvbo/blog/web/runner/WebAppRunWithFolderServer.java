/*
 * WebAppRunWithFolderServer.java 2016年10月17日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: WebAppRunWithFolderServer.java
 * @Package com.jvbo.blog.web.runner
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月17日
 */
package com.jvbo.blog.web.runner;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**  
 * @ClassName: WebAppRunWithFolderServer 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月17日
 */
public class WebAppRunWithFolderServer {

	public static void main(String[] args) throws Exception {
		System.out.println("-----------------------------jetty starting-----------------------------");
		//服务器的监听端口    
		Server server = new Server(8078);
		//关联一个已经存在的上下文
		WebAppContext context = new WebAppContext();
		//设置上下文路径既访问路径的根路径
		context.setContextPath("/blog-web");
		//context.setDefaultsDescriptor("src/test/resources/maven-jetty-webdefault.xml"); 
		//设置描述，作为hander加载使用
		context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
		//设置Web内容上下文路径
		context.setResourceBase("src/main/webapp");
        context.setParentLoaderPriority(true);
		server.setHandler(context);
		//启动
		server.start();
		System.out.println("-----------------------------jetty started-----------------------------");
		server.join();
	}
}

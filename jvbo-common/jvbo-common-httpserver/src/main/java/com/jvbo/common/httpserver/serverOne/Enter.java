/*
 * Entry.java 2017年7月19日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.httpserver.serverOne;

import java.io.IOException;

/**
 * 入口
 * @ClassName: Enter 
 * @Description: TODO
 * @author jvbo
 * @date 2017年7月19日
 */
public class Enter {
	public static void main(String[] args) {
		try {
			Server server = new Server(9999);
			server.run();
		} catch (IOException e) {
			System.err.println("server启动出错");
		}
	}
}

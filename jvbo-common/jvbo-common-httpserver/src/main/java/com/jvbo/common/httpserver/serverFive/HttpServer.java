/*
 * HttpServer.java 2017年7月19日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.httpserver.serverFive;

import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.File;

public class HttpServer {
	
	//WEB_ROOT是HTML和其他文件存放的目录,这里的WEB_ROOT为工作目录下的webroot目录
	public static final String WEB_ROOT = System.getProperty("user.dir") 
			+ File.separator + "webroot";
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	public static void main(String[] args) {
		HttpServer server = new HttpServer();
		//等待连接请求
		server.await();
	}

	public void await() {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			//服务器套接字对象
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.01"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		//循环等待一个请求
		while(true){
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			try {
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				
				//创建Request对象并解析
				Request request = new Request(input);
				request.parse();
				//检查是否是关闭服务命令
				if(request.getUri().equals(SHUTDOWN_COMMAND)){
					break;
				}
				
				//创建Response对象
				Response response = new Response(output);
				response.setRequest(request);
				response.setStaticResource();
				
				//关闭对象
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			}
		}
	}
	
}

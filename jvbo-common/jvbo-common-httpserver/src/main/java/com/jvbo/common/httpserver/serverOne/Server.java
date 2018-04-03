/*
 * Server.java 2017年7月19日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.httpserver.serverOne;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
	
	private ServerSocket server;
	
	public Server(int port) throws IOException{
		server = new ServerSocket(port);
	}
	
	@Override
	public void run(){
		try {
			for (;;) {
				Socket client = server.accept();
				Client service = new Client(client);
				service.start();
			}
		} catch (IOException e) {
			System.out.println("server IOException");
		}
		
	}
}

/*
 * Service.java 2017年7月19日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.httpserver.serverOne;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 客户端服务线程类
 * @ClassName: Service 
 * @Description: TODO
 * @author jvbo
 * @date 2017年7月19日
 */
public class Client extends Thread{

	private Socket socket;
	
	public Client(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String line = input.readLine();
			while(line != null){
				if(line.equals("quit")){
					return;
				}
				output.write(line + "\r\n");
				output.flush();
				line = input.readLine();
			}
			input.close();
			output.close();
			socket.getOutputStream().write("hello world \r\n".getBytes());
		} catch (IOException e) {
			System.out.println("连接异常");
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("关闭连接异常");
			}
		}
	}
	
	
}

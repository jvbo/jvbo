/*
 * SingleThreadWebServer.java 2017年7月19日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.httpserver.serverTwo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadWebServer implements Runnable {
	
	protected int serverPort = 9999;
	protected ServerSocket serverSocket = null;
	protected Thread runningThread = null;
	
	public SingleThreadWebServer(int port){
		this.serverPort = port;
	}
	
	@Override
	public void run() {
		synchronized (this){
			this.runningThread = Thread.currentThread();
		}
		openServerSocket();
		System.out.println("start webServer");
		while(true){
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				processClientRequest(clientSocket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void processClientRequest(Socket clientSocket) throws IOException {
		// TODO Auto-generated method stub
		InputStream input = clientSocket.getInputStream();
		OutputStream output = clientSocket.getOutputStream();
		long time = System.currentTimeMillis();
		output.write(("HTTP/1.1 200 OK\n\n<html><body>singleWebServer"+
				time+"</body></html>").getBytes());
	}

	private void openServerSocket() {
		// TODO Auto-generated method stub
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch (IOException e) {
			System.err.println("start server exception" + e);
		}
	}
	
	public static void main(String[] args) {
		SingleThreadWebServer singleThreadWebServer = new SingleThreadWebServer(9999);
		new Thread(singleThreadWebServer).start();;
	}
}

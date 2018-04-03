/*
 * MultiThreadWebServer.java 2017年7月19日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.httpserver.serverTwo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadWebServer implements Runnable {
	
	protected int serverPort = 9999;
	protected ServerSocket serverSocket = null;
	protected boolean isStopped = false;
	protected Thread runningThread = null;
	
	public MultiThreadWebServer(int port){
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
			new Thread(new WorkThread(clientSocket, "multiThreadWebServer")).start();
		}
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
		MultiThreadWebServer multiThreadWebServer = new MultiThreadWebServer(9999);
		new Thread(multiThreadWebServer).start();
	}

}

class WorkThread implements Runnable {
	
	protected Socket clientSocket = null;
	protected String serverText = null;
	
	public WorkThread(Socket clientSocket, String serverText){
		this.clientSocket = clientSocket;
		this.serverText = serverText;
	}
	
	public void doGet(){
		try {
			OutputStream outputStream = clientSocket.getOutputStream();
			outputStream.write(("HTTP/1.1 200 OK \n\n WorkThread:this is by get").getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doPost(){
		try {
			OutputStream outputStream = clientSocket.getOutputStream();
			outputStream.write(("HTTP/1.1 200 OK \n\n WorkThread: this is by post").getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			InputStream input = clientSocket.getInputStream();
			byte[] byteBuffer = new byte[1024];
			input.read(byteBuffer);
			for (byte b : byteBuffer) {
				System.out.println((char)b);
			}
			if(byteBuffer[0] == 'G' && byteBuffer[1] == 'E' && byteBuffer[2] == 'T'){
				doGet();
			}else{
				doPost();
			}
			input.close();
			System.out.println("接受到请求");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
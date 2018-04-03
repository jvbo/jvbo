/*
 * SingleFileHTTPServer.java 2017年7月19日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.httpserver.serverFour;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleFileHttpServer extends Thread {
	
	private byte[] content;
	private byte[] header;
	private int port = 80;
	
	@SuppressWarnings("unused")
	private SingleFileHttpServer(String data, String encoding,
			String MIMEType, int port) throws UnsupportedEncodingException{
		this(data.getBytes(encoding), encoding, MIMEType, port);
	}

	public SingleFileHttpServer(byte[] data, String encoding, String MIMEType, int port) throws UnsupportedEncodingException {
		this.content = data;
		this.port = port;
		String header = "HTTP/1.0 200 OK \r\n"
				+ "Server:OneFile1.0 \r\n"
				+ "Content-length:"+this.content.length+"\r\n"
				+ "Content-type:"+MIMEType+"\r\n\r\n";
		this.header = header.getBytes("ASCII");
	}

	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(this.port);
			System.out.println("accepting connections on port "+ server.getLocalPort());
			System.out.println("data to sent: ");
			System.out.write(this.content);
			while(true){
				Socket connection = null;
				try {
					connection = server.accept();
					OutputStream output = new BufferedOutputStream(connection.getOutputStream());
					InputStream input = new BufferedInputStream(connection.getInputStream());
					StringBuffer sb = new StringBuffer();
					while(true){
						int c = input.read();
						if(c == '\r' || c == '\n' || c == -1){
							break;
						}
						sb.append((char)c);
					}
					
					//如果检测到HTTP/1.0及其以后的协议，按照规范，需要发送一个MIME首部
					if(sb.toString().indexOf("HTTP/") != -1){
						output.write(this.header);
					}
					output.write(this.content);
					output.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if(connection != null){
						connection.close();
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("start server exception");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			args = new String[]{"F:\\software\\chrome-download\\test.html", String.valueOf(8088)};
			String contentType = "text/plain";
			if(args[0].endsWith(".html") || args[0].endsWith(".htm")){
				contentType = "text/html";
			}
			
			InputStream input = new FileInputStream(args[0]);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			int b;
			while((b = input.read()) != -1){
				output.write(b);
			}
			byte[]data = output.toByteArray();
			
			//端口
			int port;
			try {
				port = Integer.parseInt(args[1]);
				if(port < 1 || port > 65535){
					port = 80;
				}
			} catch (NumberFormatException e) {
				port = 80;
			}
			
			String encoding = "ASCII";
			if(args.length > 2){
				encoding = args[2];
			}
			
			Thread runningThread = new SingleFileHttpServer(data, encoding, contentType, port);
			runningThread.start();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

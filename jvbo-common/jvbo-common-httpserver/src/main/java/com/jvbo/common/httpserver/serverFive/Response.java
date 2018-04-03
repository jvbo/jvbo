/*
 * Response.java 2017年7月19日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.httpserver.serverFive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * HTTP Response = Status-Line
 *   *((general-header|response-header|entity-header)CRLF)
 *   CRLF
 *   [message-body]
 *   Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
 * @ClassName: Response 
 * @Description: TODO
 * @author jvbo
 * @date 2017年7月19日
 */
public class Response {
	
	private static final int BUFFER_SIZE = 1024;
	Request request;
	OutputStream output;

	public Response(OutputStream output) {
		this.output = output;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public void setStaticResource() {
		byte[]bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			//将web文件写入到outputStream字节流中
			File file = new File(HttpServer.WEB_ROOT, request.getUri());
			if(file.exists()){
				fis = new FileInputStream(file);
				int ch = fis.read(bytes, 0 , BUFFER_SIZE);
				while(ch != -1){
					output.write(bytes, 0, ch);
					ch = fis.read(bytes, 0, BUFFER_SIZE);
				}
			}else{
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
						+"Content-Type:text/html\r\n"
						+"Content-Lenght:23\r\n"
						+"\r\n"
						+"<h1>File Not Found</h1>";
				output.write(errorMessage.getBytes());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException:" + e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("handler file IOException:" + e.toString());
		} finally {
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("close file IOException" + e.toString());
				}
			}
		}
	}

}

/*
 * JDKWebServerTest.java 2017年7月19日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.httpserver.serverThree;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

@SuppressWarnings("restriction")
public class JDKWebServerTest {
	public static void main(String[] args) {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(9999), 0);
			server.createContext("/test", (HttpHandler) new MyHandler());
			server.setExecutor(null);
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

@SuppressWarnings("restriction")
class MyHandler implements HttpHandler{

	@Override
	public void handle(HttpExchange arg0) throws IOException {
		// TODO Auto-generated method stub
		String response = "This is the JDKWebServer";
		arg0.sendResponseHeaders(200, response.length());
		OutputStream output = arg0.getResponseBody();
		output.write(response.getBytes());
		output.close();
	}

}


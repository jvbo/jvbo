package com.jvbo.common.study.javaee.netty.nio;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/26
 */
public class TimeServer {
	public static void main(String[] args) {
		int port = 8080;
		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
		new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
	}
}

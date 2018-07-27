package com.jvbo.common.study.javaee.netty.aio;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/27
 */
public class TimeServer {
	public static void main(String[] args) {
		int port = 8080;
		AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
		new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
	}
}

package com.jvbo.common.study.javaee.netty.aio;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/27
 */
public class TimeClient {
	public static void main(String[] args) {
		int port = 8080;
		new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClientHandler-001").start();
	}
}

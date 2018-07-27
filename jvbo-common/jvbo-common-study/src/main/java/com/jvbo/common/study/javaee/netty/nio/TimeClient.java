package com.jvbo.common.study.javaee.netty.nio;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/25
 */
public class TimeClient {
	public static void main(String[] args) {
		int port = 8080;
		new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
	}
}

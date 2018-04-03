/*
 * TestRoundRobin.java 2017年6月28日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.roundrobin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestRoundRobin {
	static Map<String, String> serverWeigthMap = new HashMap<String, String>();

	static {
		serverWeigthMap.put("1", "1");
		serverWeigthMap.put("2", "2");
		serverWeigthMap.put("3", "3");
		serverWeigthMap.put("4", "4");
		serverWeigthMap.put("5", "5");
		serverWeigthMap.put("6", "6");
		serverWeigthMap.put("7", "7");
		serverWeigthMap.put("8", "8");
	}
	Integer pos = 0;

	public String roundRobin() {
		// 重建一个Map，避免服务器的上下线导致的并发问题
		Map<String, String> serverMap = new HashMap<String, String>();
		serverMap.putAll(serverWeigthMap);
		// 取得Ip地址List
		Set<String> keySet = serverMap.keySet();
		ArrayList<String> keyList = new ArrayList<String>();
		keyList.addAll(keySet);

		String server = null;

		synchronized (pos) {
			if (pos >= keySet.size()) {
				pos = 0;
			}
			server = keyList.get(pos);
			pos++;
		}
		return server;
	}

	public static void main(String[] args) {
		TestRoundRobin robin = new TestRoundRobin();
		for (int i = 0; i < 16; i++) {
			String serverIp = robin.roundRobin();
			System.out.println(serverIp);
		}
	}
}

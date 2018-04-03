/*
 * ConnectionPoolFactory.java 2017年7月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.connectionpool.poolTwo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 连接池管理类
 * @ClassName: ConnectionPoolFactory 
 * @Description: TODO
 * @author jvbo
 * @date 2017年7月20日
 */
public class ConnectionPoolFactory {
	
	private ConnectionPoolFactory(){}
	
	private static Map<String, ConnectionPool> poolMap = new ConcurrentHashMap<>();
	
	public static Connection getConnection(String poolName) throws SQLException{
		nameCheck(poolName);
		ConnectionPool connectionPool = poolMap.get(poolName);
		return connectionPool.getConnection();
	}
	
	//TODO
	public static void registerConnectionPool(String name, ConnectionParam connectionParam){
		registerCheck(name);
		poolMap.put(name, new ConnectionPool(connectionParam));
	}
	
	//TODO let gc
	public static void unRegisterConnectionPool(String name){
		nameCheck(name);
		final ConnectionPool connectionPool = poolMap.get(name);
		poolMap.remove(name);
		new Thread(new Runnable(){
			@Override
			public void run() {
				connectionPool.clear();
			}
		}).start();
	}
	
	//TODO
	public static int size(String poolName){
		nameCheck(poolName);
		return poolMap.get(poolName).size();
	}
	
	//TODO
	public static int getIdleConnectionQuantity(String poolName){
		nameCheck(poolName);
		return poolMap.get(poolName).idleConnectionQuantity();
	}
	
	//TODO
	public static int getBusyConnectionQuantity(String poolName){
		nameCheck(poolName);
		return poolMap.get(poolName).busyConnectionQuantity();
	}
	
	//TODO 
	private static void registerCheck(String name) {
		if(name == null){
			throw new IllegalArgumentException(nullName());
		}
	}

	//TODO
	private static void nameCheck(String poolName) {
		if(poolName == null){
			throw new IllegalArgumentException(nullName());
		}
		if(!poolMap.containsKey(poolName)){
			throw new IllegalArgumentException(notExists(poolName));
		}
	}
	
	//TODO
	private static String notExists(String poolName) {
		return "connection pool named " + poolName + "does not exists";
	}
	
	//TODO
	private static String nullName() {
		return "pool name must not be null";
	}
	
}

/*
 * ConnectionPoolTest.java 2017年7月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.connectionpool.poolTwo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ConnectionPoolTest {
	
	//TODO
	@Test
	public void testGetConnection() throws SQLException{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.1.160:3306/jfinal_base";
		String user = "root";
		String password = "111111";
		
		ConnectionParam connectionParam = new ConnectionParam.ConnectionParamBuilder(driver,
				url, user, password).build();
		ConnectionPoolFactory.registerConnectionPool("test", connectionParam);
		List<Connection> connectionList = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			connectionList.add(ConnectionPoolFactory.getConnection("test"));
		}
		print();
		close(connectionList);
		print();
		connectionList.clear();
		for (int i = 0; i < 12; i++) {
			connectionList.add(ConnectionPoolFactory.getConnection("test"));
		}
		print();
		close(connectionList);
		
		ConnectionPoolFactory.unRegisterConnectionPool("test");
	}
	
	//TODO
	public void testException(){
		try {
			ConnectionPoolFactory.getConnection("test");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//TODO 
	private void close(List<Connection> connectionList) throws SQLException {
		for (Connection connection : connectionList) {
			if(connection != null){
				connection.close();
			}
		}
	}
	
	//TODO
	private void print() {
		System.out.println("idle:" + ConnectionPoolFactory.getIdleConnectionQuantity("test"));
		System.out.println("busy:" + ConnectionPoolFactory.getBusyConnectionQuantity("test"));
		System.out.println("size:" + ConnectionPoolFactory.size("test"));
	}
}

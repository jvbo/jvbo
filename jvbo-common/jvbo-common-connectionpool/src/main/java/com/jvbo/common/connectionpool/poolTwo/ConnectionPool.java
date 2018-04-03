/*
 * ConnectionPool.java 2017年7月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.connectionpool.poolTwo;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据库连接池
 * @ClassName: ConnectionPool 
 * @Description: TODO
 * @author jvbo
 * @date 2017年7月20日
 */
public class ConnectionPool implements DataSource {
	
	private static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
	
	private static final int INITIAL_SIZE = 5;
	private static final String CLOSE_METHOD = "close";
	private int size;
	private ConnectionParam connectionParam;
	private ArrayBlockingQueue<Connection> idleConnectionQueue;
	private Vector<Connection> busyConnectionVector;
	
	protected ConnectionPool(ConnectionParam connectionParam){
		this.connectionParam = connectionParam;
		int maxConnection = connectionParam.getMaxConnection();
		idleConnectionQueue = new ArrayBlockingQueue<>(maxConnection);
		busyConnectionVector = new Vector<>();
		initConnection();
	}
	
	//TODO
	private void initConnection() {
		int minConnection = connectionParam.getMinConnection();
		int initialSize = INITIAL_SIZE < minConnection ? minConnection : INITIAL_SIZE;
		try {
			Class.forName(connectionParam.getDriver());
			for (int i = 0; i < initialSize + minConnection; i++) {
				idleConnectionQueue.put(newConnection());
				size ++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//TODO
	private Connection newConnection() throws SQLException {
		String url = connectionParam.getUrl();
		String user = connectionParam.getUser();
		String password = connectionParam.getPassword();
		return DriverManager.getConnection(url, user, password);
	}
	
	protected int size(){
		return size;
	}
	
	protected int idleConnectionQuantity(){
		return idleConnectionQueue.size();
	}
	
	protected int busyConnectionQuantity(){
		return busyConnectionVector.size();
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	//TODO 
	@Override
	public Connection getConnection() throws SQLException {
		try {
			final Connection connection = idleConnectionQueue.poll(connectionParam.getMaxWait(), TimeUnit.MILLISECONDS);
			if(connection == null){
				logger.info(emptyMsg());
				ensureCapacity();
				return null;
			}
			busyConnectionVector.add(connection);
			return (Connection)Proxy.newProxyInstance(this.getClass().getClassLoader(),
					new Class[]{Connection.class}, new InvocationHandler(){
						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							if(!method.getName().equals(CLOSE_METHOD)){
								return method.invoke(connection, args);
							}else{
								idleConnectionQueue.offer(connection);
								busyConnectionVector.remove(connection);
								return null;
							}
						}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//TODO 
	private void ensureCapacity() throws InterruptedException, SQLException {
		int minIdle = connectionParam.getMinIdle();
		int maxConnection = connectionParam.getMaxConnection();
		int newCapacity = size + minIdle;
		newCapacity = newCapacity > maxConnection ? maxConnection : newCapacity;
		int growCount = 0;
		if(size < newCapacity){
			for (int i = 0; i < newCapacity - size; i++) {
				idleConnectionQueue.put(newConnection());
				growCount++;
			}
		}
		size = size + growCount;
	}
	
	//TODO
	protected void clear(){
		try {
			while(size-- > 0){
				Connection connection = idleConnectionQueue.take();
				connection.close();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//TODO
	private String emptyMsg() {
		return "database is busy ,please wait...";
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}

/*
 * ConnectionParam.java 2017年7月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.connectionpool.poolTwo;

/**
 * 数据库连接池参数类，配置数据库连接以及连接池相关参数
 * @ClassName: ConnectionParam 
 * @Description: TODO
 * @author jvbo
 * @date 2017年7月20日
 */
public class ConnectionParam {
	private final String driver;
	private final String url;
	private final String user;
	private final String password;
	private final int minConnection;
	private final int maxConnection;
	private final int minIdle;
	private final long maxWait;
	
	private ConnectionParam(ConnectionParamBuilder connectionParamBuilder){
		this.driver = connectionParamBuilder.driver;
		this.url = connectionParamBuilder.url;
		this.user = connectionParamBuilder.user;
		this.password = connectionParamBuilder.password;
		this.minConnection = connectionParamBuilder.minConnection;
		this.maxConnection = connectionParamBuilder.maxConnection;
		this.minIdle = connectionParamBuilder.minIdle;
		this.maxWait = connectionParamBuilder.maxWait;
	}
	
	public String getDriver(){
		return this.driver;
	}
	
	public String getUrl(){
		return this.url;
	}
	
	public String getUser(){
		return this.user;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public int getMinConnection(){
		return this.minConnection;
	}
	
	public int getMaxConnection(){
		return this.maxConnection;
	}
	
	public int getMinIdle(){
		return this.minIdle;
	}
	
	public long getMaxWait(){
		return this.maxWait;
	}
	
	public static class ConnectionParamBuilder implements Builder<ConnectionParam> {
		//必须参数4个
		private final String driver;
		private final String url;
		private final String user;
		private final String password;
		
		//可选参数4个
		private int minConnection = ParamConfiguration.MIN_CONNECTION;
		private int maxConnection = ParamConfiguration.MAX_CONNECTION;
		private int minIdle = ParamConfiguration.MIN_IDLE;
		private long maxWait = ParamConfiguration.MAX_WAIT;
		
		public ConnectionParamBuilder(String driver, String url, String user, 
				String password){
			this.driver = driver;
			this.url = url;
			this.user = user;
			this.password = password;
		}
		
		public ConnectionParamBuilder minConnection(int minConnection){
			this.minConnection = minConnection;
			return this;
		}
		
		public ConnectionParamBuilder maxConnection(int maxConnection){
			this.maxConnection = maxConnection;
			return this;
		}
		
		public ConnectionParamBuilder minIdle(int minIdle){
			this.minIdle = minIdle;
			return this;
		}
		
		public ConnectionParamBuilder maxWait(int maxWait){
			this.maxWait = maxWait;
			return this;
		}
		
		@Override
		public ConnectionParam build() {
			// TODO Auto-generated method stub
			return new ConnectionParam(this);
		}
		
	}
}

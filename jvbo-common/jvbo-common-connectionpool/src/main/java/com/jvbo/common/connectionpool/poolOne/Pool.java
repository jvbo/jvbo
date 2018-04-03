/*
 * Pool.java 2017年7月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.connectionpool.poolOne;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Pool {
	
	private String jdbcDriver = "";//数据库驱动
	private String dbUrl = "";//数据库url
	private String dbUsername = "";//数据库用户名
	private String dbPassword = "";//数据库密码
	private String testTable = "";
	private int initialConnectionsNum = 10;//连接池初始化连接数
	private int maxConnectionsNum = 50;//连接池最大连接数
	private int incrementalConnections = 5;//每次动态添加连接数
	private Vector<PooledConnection> connections = null;//向量，存放连接池中初始连接，初始为空
	
	public Pool(){}
	
	//TODO 初始化数据库驱动、数据库url、数据库用户名、数据库密码、测试表
	public Pool(String driver, String url, String name, String password) {
		this.jdbcDriver = driver;
		this.dbUrl = url;
		this.dbUsername = name;
		this.dbPassword = password;
		try {
			this.createPool();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TODO 创建连接池
	private void createPool() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		//如果已经创建，则保存连接的向量不为空
		if(this.connections != null){
			return;
		}
		//驱动器实例化
		Driver driver = (Driver)(Class.forName(this.jdbcDriver).newInstance());
		//注册驱动器
		DriverManager.registerDriver(driver);
		//创建保存连接的向量
		this.connections = new Vector<PooledConnection>();
		//创建数据库连接
		this.createConnections(this.initialConnectionsNum);
		
	}
	
	//TODO 创建数据库连接
	private void createConnections(int initialConnectionsNum) throws SQLException {
		//循环创建连接，首先检查当前连接数是否超出连接池最大连接数
		for (int i = 0; i < initialConnectionsNum; ++i) {
			//检查
			if(this.connections.size() >= this.maxConnectionsNum){
				return;
			}
			//创建连接
			this.connections.addElement(new PooledConnection(newConnection()));
		}
	}
	
	//TODO 创建一个数据库连接
	private Connection newConnection() throws SQLException {
		//创建连接
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		//如果是第一次创建连接，则检查所连接的数据库的允许最大连接数是否小于设定的最大连接数
		if(this.connections.size() == 0){
			DatabaseMetaData metadata = con.getMetaData();
			//数据库最大连接数
			int dbMaxConnectionsNum = metadata.getMaxConnections();
			//如果数据库最大连接池更小，则更改所设定的连接池最大连接数
			if(dbMaxConnectionsNum > 0 && this.maxConnectionsNum > dbMaxConnectionsNum){
				this.maxConnectionsNum = dbMaxConnectionsNum;
			}
		}
		return con;
	}
	
	//TODO 得到一个可用连接
	public synchronized Connection getConnection() throws SQLException{
		Connection con = null;
		//检查连接池是否建立
		if(this.connections == null){
			return con;
		}
		//得到可用连接
		con = this.getFreeConnection();
		while(con == null){
			this.wait(30);
			con = this.getFreeConnection();
		}
		return con;
	}
	
	//TODO 得到一个可用连接
	private Connection getFreeConnection() throws SQLException {
		Connection con = null;
		//查找一个可用连接
		con = this.findFreeConnection();
		//如果未找到可用连接，就建立一个新的连接，再次查找
		if(con == null){
			this.createConnections(this.incrementalConnections);
			//再次查找
			con = this.findFreeConnection();
		}
		return con;
	}
	
	//TODO 从现有连接中查找一个可用连接，在向量connections中找到一个空闲连接，并测试是否可用
	//不可用则重新建立连接，替换原来的连接
	private Connection findFreeConnection() throws SQLException {
		Connection con = null;
		for (int i = 0; i < this.connections.size(); ++i) {
			PooledConnection pol = (PooledConnection)this.connections.get(i);
			if(!pol.isBusy()){
				//如果此连接未被使用，则返回这个连接并设置正在使用标识
				con = pol.getCon();
				pol.setBusy(true);
				//测试连接是否可用
				if(!this.testCon(con)){
					con = this.newConnection();
					pol.setCon(con);
				}
				break;
			}
		}
		return con;
	}
	
	//TODO 测试连接是否可用
	private boolean testCon(Connection con) {
		boolean useable = true;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(*) form " + this.testTable);
			rs.next();
		} catch (SQLException e) {
			//抛出异常，连接不可用，关闭
			useable = false;
			this.closeConnection(con);
		}
		return useable;
	}
	
	//TODO 将使用完毕的连接放回连接池中
	public void returnConnetion(Connection con){
		//确保连接池存在
		if(this.connections == null){
			return;
		}
		for (int i = 0; i < this.connections.size(); ++i) {
			PooledConnection pool = this.connections.get(i);
			if(con == pool.getCon()){
				pool.setBusy(false);
			}
		}
	}
	
	//TODO 刷新连接池中的连接
	public synchronized void refreshConnectionPool() throws SQLException{
		//确保连接池存在
		if(this.connections == null){
			return;
		}
		for (int i = 0; i < this.connections.size(); ++i) {
			PooledConnection pool = this.connections.get(i);
			if(pool.isBusy()){
				this.wait(5000);
			}
			this.closeConnection(pool.getCon());
			pool.setCon(this.newConnection());
			pool.setBusy(false);
		}
	}
	
	//TODO 关闭连接池
	public void closeConnectionPool(){
		//确保连接池存在
		if(this.connections == null){
			return;
		}
		for (int i = 0; i < this.connections.size(); ++i) {
			PooledConnection pool = this.connections.get(i);
			if(pool.isBusy()){
				this.wait(5000);
			}
			this.closeConnection(pool.getCon());
			this.connections.remove(i);
		}
		this.connections = null;
	}
	
	//TODO 暂时无可用连接，进入等待队列等待m秒再试
	public void wait(int mSecond){
		try {
			Thread.sleep(mSecond);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//关闭连接
	private void closeConnection(Connection con) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		Pool pool = new Pool("com.mysql.jdbc.Driver", "jdbc:mysql://192.168.1.160:3306/jfinal_base", "root", "111111");
		try {
			pool.createConnections(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn = pool.getConnection();
			String sql = "select * from t_user where loginName='admin' ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("loginName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getTestTable() {
		return testTable;
	}

	public void setTestTable(String testTable) {
		this.testTable = testTable;
	}

	public int getInitialConnectionsNum() {
		return initialConnectionsNum;
	}

	public void setInitialConnectionsNum(int initialConnectionsNum) {
		this.initialConnectionsNum = initialConnectionsNum;
	}

	public int getMaxConnectionsNum() {
		return maxConnectionsNum;
	}

	public void setMaxConnectionsNum(int maxConnectionsNum) {
		this.maxConnectionsNum = maxConnectionsNum;
	}

	public int getIncrementalConnections() {
		return incrementalConnections;
	}

	public void setIncrementalConnections(int incrementalConnections) {
		this.incrementalConnections = incrementalConnections;
	}

	public Vector<PooledConnection> getConnections() {
		return connections;
	}

	public void setConnections(Vector<PooledConnection> connections) {
		this.connections = connections;
	}
	
	
	
	class PooledConnection{
		private Connection con = null;//连接
		private boolean busy = false;//是否正在使用，默认非

		public PooledConnection(Connection con){
			this.con = con;
		}
		
		public boolean isBusy(){
			return busy;
		}
		
		public Connection getCon() {
			return con;
		}

		public void setCon(Connection con) {
			this.con = con;
		}

		public void setBusy(boolean busy) {
			this.busy = busy;
		}
	}
}

/*
 * ConnectionHolder.java 2018年4月2日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 使用ThreadLocal来维持线程封闭性
 * @ClassName: ConnectionHolder 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月2日
 */
public class ConnectionHolder {
    
    private static final String DB_URL = "";
    
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>(){
        public Connection initialValue(){
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            }
            return null;
        }
    };
    public static Connection getConnection(){
        return connectionHolder.get();
    }
    
}

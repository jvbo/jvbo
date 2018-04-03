/*
 * Test.java 2017年12月7日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.connectionpool.poolTwo;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

public class Test {
	private static String dirverClassName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://192.168.1.66:3306/edobee?useUnicode=true&characterEncoding=utf8";
    private static String user = "root";
    private static String password = "edobe";
    
    private static String userId = "2edda5f69a1b46ddb9e73921b087f24d";
    private static String storeId = "168821795f484962bde026e3741378ea";
    private static String accessToken = "61026026451a4735f37f50c1ddc51b4bc74b43ac72d641f1624961198";
    private static String refreshToken = "6100e02a621da25fcd9617be0edc805bce364588542877f1624961198";
	public static void main(String[] args) {
		String str = "session: 6102106634143716c5611f9320346360e0a43a1993af90a1624961198 refresh_token: 61009068764a791b7a0da1659ca3367157f53a8843cd5ec1624961198";
		String[] arrs = StringUtils.split(str, " ");
		System.out.println(JSON.toJSONString(arrs));
		String session = arrs[1];
		String refreshToken = arrs[3];
		System.out.println("session:" + session + "====" +"refreshToken:" + refreshToken);
	}
	
	private static void excuteSql(){
        QueryRunner queryRunner = new QueryRunner();
        try {
            Class.forName(dirverClassName);
    		Connection conn = DriverManager.getConnection(url, user, password);
            String sqlUpdStore = "update store set `status`=1 where userId=? and platform=58 ";
            int storeResult = queryRunner.update(conn, sqlUpdStore, new Object[]{userId});
            System.out.println("storeResult:" + storeResult);
            String sqlUpdAuth = "update authorization set accessToken=?, refreshToken=? where storeId=?;"; 
            int authResult = queryRunner.update(conn, sqlUpdAuth, new Object[]{accessToken,refreshToken,storeId});
            System.out.println("authResult:" + authResult);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}

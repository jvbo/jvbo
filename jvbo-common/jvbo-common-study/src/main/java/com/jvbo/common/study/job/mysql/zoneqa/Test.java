package com.jvbo.common.study.job.mysql.zoneqa;

import java.sql.*;
import java.util.Date;
import java.util.TimeZone;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2019/4/17
 */
public class Test {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://rm-bp11nir2u66x0901poo.mysql.rds.aliyuncs.com:3306/jvbo?useSSL=false&characterEncoding=UTF-8&autoReconnect=true";
        String user = "jvbo";
        String password = "jvbo@2019";
        //1.默认时区GMT+8:00,插入
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement psmt = conn.prepareStatement("insert into test_table (ts) values (?)")) {
            System.out.println("驱动版本：" + conn.getMetaData().getDriverVersion());
            Date date = new Date();
            System.out.println("当前时间: " + date.toString());
            psmt.setTimestamp(1, new Timestamp(date.getTime()));
            psmt.executeUpdate();
        }
        //2.时区改为GMT-6:00,插入
        System.setProperty("user.timezone", "GMT-6");
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-6"));
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement psmt = conn.prepareStatement("insert into test_table (ts) values (?)")) {
            Date date = new Date();
            System.out.println("当前时间: " + date.toString());
            psmt.setTimestamp(1, new Timestamp(date.getTime()));
            psmt.executeUpdate();
        }
        //3.执行一遍写死的SQL
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement psmt = conn.prepareStatement("insert into test_table (ts) values ('2019-04-17 00:00:00')")) {
            psmt.executeUpdate();
        }
    }

}

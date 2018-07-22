/*
 * JSONPaser.java 2018年6月15日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.job.json;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

public class JSONPaser {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("F:/software/git/repo/jvbo/jvbo-common/jvbo-common-study/src/main/resources/json/base.json");
        String baseJson = IOUtils.toString(inputStream,"utf8");
        JSONObject jo = JSON.parseObject(baseJson);
        List<JSONObject> sourceJa = JSON.parseArray(jo.getJSONObject("data").getString("list"), JSONObject.class);
        
        JdbcTemplate jdbcTemplate = SingletonJdbcTemplate.INSTANCE.getJdbcTemplate();
        List<Map<String,Object>> queryResult = jdbcTemplate.queryForList("select * from t_coin_base_info");
        List<JSONObject> targetJa = JSON.parseArray(JSON.toJSONString(queryResult), JSONObject.class);
        
        /*String insertSql = "INSERT INTO `t_test` (`blockcc_uid`, `blockcc_id`, `name`, `symbol`) VALUES (?, ?, ?, ?)";
        sourceJa.forEach(source -> {
            try {
                jdbcTemplate.update(insertSql, new Object[]{source.getString("_id"), source.getString("id"), 
                        source.getString("name"), source.getString("symbol")});
            } catch (DataAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Thread.currentThread().interrupted();
            }
        });*/
        
        System.out.println("json数据数量:" + sourceJa.size());
        System.out.println("数据库数据数量:" + targetJa.size());
        
        List<JSONObject> resultList = Lists.newLinkedList(sourceJa);
        sourceJa.forEach(source -> {
            targetJa.forEach(target -> {
                if(source.getString("_id").equalsIgnoreCase(target.getString("_id")))
                    resultList.remove(source);
            });
        });
        System.out.println("相差数量:" + resultList.size());
        System.out.println(JSON.toJSONString(resultList));
        resultList.forEach(item -> {
            System.out.println(JSON.toJSONString(item));
        });
    }
    
    private enum SingletonJdbcTemplate {
        INSTANCE;
        private JdbcTemplate jdbcTemplate;
        
        SingletonJdbcTemplate (){
            DriverManagerDataSource dataSource=new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://rm-bp1rqx1ig1rzp85v0o.mysql.rds.aliyuncs.com:3306/heiyu_test?useSSL=false");
            dataSource.setUsername("heiyu_test");
            dataSource.setPassword("96a9519b");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        
        public JdbcTemplate getJdbcTemplate(){
            return jdbcTemplate;
        }
        
    }
}

package com.jvbo.springboot.practice.runner;

import java.util.HashMap;
import java.util.Map;

import com.jvbo.springboot.practice.framework.util.MybatisGeneratorUtil;
import com.jvbo.springboot.practice.framework.util.PropertiesFileUtil;

/**
 * 代码生成类
 */
public class Generator {

	// 根据命名规范，只修改此常量值即可
	private static String MODULE = "jvbo-springboot-practice";
	private static String DATABASE = "jvbo";
	private static String TABLE_PREFIX = "t_";
	private static String PACKAGE_NAME = "com.jvbo.springboot.practice";
    private static String MAPPER_XML = "mapper.generate";
	private static String JDBC_DRIVER = PropertiesFileUtil.getInstance("application-dev").get("generator.jdbc.driver");
	private static String JDBC_URL = PropertiesFileUtil.getInstance("application-dev").get("generator.jdbc.url");
	private static String JDBC_USERNAME = PropertiesFileUtil.getInstance("application-dev").get("generator.jdbc.username");
	private static String JDBC_PASSWORD = PropertiesFileUtil.getInstance("application-dev").get("generator.jdbc.password");
	// 需要insert后返回主键的表配置，key:表名,value:主键名
	private static Map<String, String> LAST_INSERT_ID_TABLES = new HashMap<>();
	static {
	    
	}

	/**
	 * 自动代码生成
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		MybatisGeneratorUtil.generator(JDBC_DRIVER, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD, MODULE, DATABASE, TABLE_PREFIX, PACKAGE_NAME, MAPPER_XML, LAST_INSERT_ID_TABLES);
	}

}

/*
 * MybatisGeneratorRun.java 2016年10月14日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: MybatisGeneratorRun.java
 * @Package com.jvbo.blog.dal.runner
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月14日
 */
package com.jvbo.springboot.template.admin.runner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @ClassName: MybatisGeneratorRun 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月14日
 */
public class MybatisGeneratorRun {

	/**
	 * @Description: TODO
	 * @param @param args   
	 * @return void  
	 * @throws XMLParserException 
	 * @throws IOException 
	 * @throws InvalidConfigurationException 
	 * @throws InterruptedException 
	 * @throws SQLException 
	 * @throws
	 * @author jvbo
	 * @date 2016年10月14日
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("generator start...");
		List<String> warnings = new ArrayList<String>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(MybatisGeneratorRun.class.getClassLoader().getResourceAsStream("generatorConfig.xml"));  
        DefaultShellCallback callback = new DefaultShellCallback(true);  
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
		for (String string : warnings) {
			System.out.println(string);
		}
		System.out.println("generator end...");
	}

}

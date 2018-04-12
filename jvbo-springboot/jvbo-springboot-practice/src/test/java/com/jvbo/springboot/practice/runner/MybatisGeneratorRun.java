/*
 * MybatisGeneratorRun.java 2016年10月14日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.runner;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: MybatisGeneratorRun 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月14日
 */
public class MybatisGeneratorRun {

    private static final Logger logger = LoggerFactory.getLogger(MybatisGeneratorRun.class);

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
        logger.info("generator start...");
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(MybatisGeneratorRun.class.getClassLoader().getResourceAsStream("generator-config.xml"));  
        DefaultShellCallback callback = new DefaultShellCallback(true);  
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String string : warnings) {
            logger.info(string);
        }
        logger.info("generator end...");
    }

}

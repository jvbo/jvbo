/*
 * ITestManager.java 2018年5月10日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.core.manager.test;

import java.math.BigDecimal;

public interface ITestManager {
    
    boolean batchInsert();
    
    BigDecimal execTime();

    String transaction();
}

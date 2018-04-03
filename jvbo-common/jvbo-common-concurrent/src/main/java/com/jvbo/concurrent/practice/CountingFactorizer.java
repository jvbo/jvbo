/*
 * CountingFactorizer.java 2018年4月2日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.jvbo.concurrent.practice.annotation.ThreadSafe;

/**
 * 使用AtomicLong类型的变量来统计已处理请求的数量
 * @ClassName: CountingFactorizer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月2日
 */
@ThreadSafe
public class CountingFactorizer implements Servlet {
    
    private final AtomicLong count = new AtomicLong(0);
    
    public long getCount(){return count.get();}

    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(res, factors);
    }

    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }
    
    private BigInteger extractFromRequest(ServletRequest req) {
        // TODO Auto-generated method stub
        return null;
    }

    private void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
        // TODO Auto-generated method stub
        
    }

    private BigInteger[] factor(BigInteger i) {
        // TODO Auto-generated method stub
        return null;
    }
}

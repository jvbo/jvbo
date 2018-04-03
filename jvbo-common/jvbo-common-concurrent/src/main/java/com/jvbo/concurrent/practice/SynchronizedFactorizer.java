/*
 * SynchronizedFactorizer.java 2018年4月2日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.jvbo.concurrent.practice.annotation.GuardedBy;
import com.jvbo.concurrent.practice.annotation.ThreadSafe;

/**
 * 该Servlet能正确地缓存最新的计算结果,但并发性却非常糟糕(不要这么做)
 * @ClassName: SynchronizedFactorizer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月2日
 */
@ThreadSafe
public class SynchronizedFactorizer implements Servlet {
    
    @GuardedBy("this")
    private BigInteger lastNumber;
    
    @GuardedBy("this")
    private BigInteger[] lastFactors;

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
    public synchronized void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        if(i.equals(lastNumber))
            encodeIntoResponse(res, lastFactors);
        else{
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            encodeIntoResponse(res, factors);
        }
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

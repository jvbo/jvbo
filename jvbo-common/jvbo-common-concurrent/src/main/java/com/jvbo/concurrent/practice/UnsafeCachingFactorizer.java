/*
 * UnsafeCachingFactorizer.java 2018年4月2日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.jvbo.concurrent.practice.annotation.NotThreadSafe;

/**
 * 该Servlet在没有足够原子性保证的情况下对其最近计算结果进行缓存(不要这么做)
 * @ClassName: UnsafeCachingFactorizer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月2日
 */
@NotThreadSafe
public class UnsafeCachingFactorizer implements Servlet {
    
    private final AtomicReference<BigInteger> lastNumber = new 
            AtomicReference<BigInteger>();

    private final AtomicReference<BigInteger[]> lastFactors = new 
            AtomicReference<BigInteger[]>();

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
        if(i.equals(lastNumber.get()))
            encodeIntoResponse(res, lastFactors.get());
        else{
            BigInteger[] factors = factor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
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

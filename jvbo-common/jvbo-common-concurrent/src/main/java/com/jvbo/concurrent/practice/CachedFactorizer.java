/*
 * CachedFactorizer.java 2018年4月2日
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

@ThreadSafe
public class CachedFactorizer implements Servlet {
    
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;
    
    public synchronized long getHits(){return hits;}
    public synchronized double getCacheHitsRatio(){
        return (double)cacheHits/(double)hits;
    }
    

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
        BigInteger[] factors = null;
        synchronized(this){
            ++hits;
            if(i.equals(lastNumber)){
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if(factors == null){
            factors = factor(i);
            synchronized(this){
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
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

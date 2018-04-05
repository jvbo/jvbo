/*
 * Factorizer.java 2018年4月5日
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

import com.jvbo.concurrent.practice.cache.Computable;
import com.jvbo.concurrent.practice.cache.Memoizer;

/**
 * 在因式分解servlet中使用Memoizer来缓存结果
 * @ClassName: Factorizer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月5日
 */
public class Factorizer implements Servlet {
    private final Computable<BigInteger, BigInteger[]> c = new Computable<BigInteger, BigInteger[]>(){

        @Override
        public BigInteger[] compute(BigInteger arg) throws InterruptedException {
            // TODO Auto-generated method stub
            return factor(arg);
        }
        
    };
    
    private final Computable<BigInteger, BigInteger[]> cache = new Memoizer<BigInteger, BigInteger[]>(c);
    

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
        try {
            encodeIntoResponse(res, cache.compute(i));
        } catch (InterruptedException e) {
            encodeError(res, "factorization interrupted");
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

    private void encodeError(ServletResponse res, String string) {
        // TODO Auto-generated method stub
        
    }

}

/*
 * Services.java 2018年1月29日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * noninstantiable class for service registration and access 
 * @ClassName: Services 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月29日
 */
public class Services {
    
    private Services(){}
    
    // Maps service names to services 
    private static final Map<String, Provider> providers = 
            new ConcurrentHashMap<>();
    private static final String DEFAULT_PROVIDER_NAME = "<def>";
    
    // Provider registration API
    public static void registrationDefaultProvider(Provider p){
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String defaultProviderName, Provider p) {
        providers.put(defaultProviderName, p);
    }
    
    // Service access API
    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String defaultProviderName) {
        Provider p = providers.get(defaultProviderName);
        if(p == null){
            throw new IllegalArgumentException("no provider registed with name:" + defaultProviderName);
        }
        return p.newService();
    }
    
    
}

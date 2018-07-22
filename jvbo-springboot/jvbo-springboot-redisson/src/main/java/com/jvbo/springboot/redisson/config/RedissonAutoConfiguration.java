/*
 * RedissonAutoAutoConfiguration.java 2018年6月30日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.redisson.config;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jvbo.springboot.redisson.lock.IDistributedLock;
import com.jvbo.springboot.redisson.lock.RedissLockUtil;
import com.jvbo.springboot.redisson.lock.RedissonDistributedLock;

@Configuration
@ConditionalOnProperty("redisson.password")
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfiguration {
    
    @Autowired
    private RedissonProperties redssionProperties;

    /**
     * 单机
     * @Description: TODO
     * @param @return   
     * @return RedissonClient  
     * @throws
     * @author jvbo
     * @date 2018年6月30日
     */
    @Bean
    @ConditionalOnProperty(name="redisson.address")
    public RedissonClient redissonSingle() {
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(redssionProperties.getAddress())
                .setTimeout(redssionProperties.getTimeout())
                .setConnectionPoolSize(redssionProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redssionProperties.getConnectionMinimumIdleSize());
        
        if(StringUtils.isNotBlank(redssionProperties.getPassword())) {
            serverConfig.setPassword(redssionProperties.getPassword());
        }

        return Redisson.create(config);
    }
    
    /**
     * 哨兵模式
     * @Description: TODO
     * @param @return   
     * @return RedissonClient  
     * @throws
     * @author jvbo
     * @date 2018年6月30日
     */
    @Bean(destroyMethod="shutdown")
    @ConditionalOnProperty(name="redisson.master-name")
    public RedissonClient redissonSentinel() {
        Config config = new Config();
        SentinelServersConfig serverConfig = config.useSentinelServers()
                .addSentinelAddress(redssionProperties.getSentinelAddresses())
                .setMasterName(redssionProperties.getMasterName())
                .setTimeout(redssionProperties.getTimeout())
                .setMasterConnectionPoolSize(redssionProperties.getMasterConnectionPoolSize())
                .setSlaveConnectionPoolSize(redssionProperties.getSlaveConnectionPoolSize());
        
        if(StringUtils.isNotBlank(redssionProperties.getPassword())) {
            serverConfig.setPassword(redssionProperties.getPassword());
        }
        
        return Redisson.create(config);
    }

    /**
     * 装配lock类,并将实例注入到RedissLockUtil中
     * @Description: TODO
     * @param @param redissonClient
     * @param @return   
     * @return IDistributedLock  
     * @throws
     * @author jvbo
     * @date 2018年6月30日
     */
    @Bean
    public IDistributedLock distributedLock(RedissonClient redissonClient) {
        RedissonDistributedLock lock = new RedissonDistributedLock();
        lock.setRedissonClient(redissonClient);
        RedissLockUtil.setLock(lock);
        return lock;
    }
}

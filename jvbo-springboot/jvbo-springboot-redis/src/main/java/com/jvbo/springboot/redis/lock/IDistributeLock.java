/*
 * IDistributeLock.java 2018年6月29日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.redis.lock;

import java.util.concurrent.TimeUnit;

public interface IDistributeLock {
    
    /**
     * 获取锁,如果成功立即返回,不等待,否则true
     * @Description: TODO
     * @param @param lockKey
     * @param @param lockValue
     * @param @return   
     * @return boolean  
     * @throws
     * @author jvbo
     * @date 2018年6月30日
     */
    boolean tryLock(String lockKey, String lockValue);
    
    /**
     * 锁在timeout时间内空闲,则获取锁成功
     * @Description: TODO
     * @param @param lockKey
     * @param @param timeout
     * @param @param unit
     * @param @return   
     * @return boolean  
     * @throws
     * @author jvbo
     * @date 2018年6月30日
     */
    boolean tryLock(String lockKey, String lockValue, int lockSeconds);
    
    /**
     * 轮询获取锁,成功true,超过轮询次数/异常返回false
     * @Description: TODO
     * @param @param lockKey
     * @param @param lockValue
     * @param @param lockSeconds
     * @param @param tryIntervalMillis 轮询时间间隔(millSeconds)
     * @param @param maxTryCount 最大轮询次数
     * @param @return   
     * @return boolean  
     * @throws
     * @author jvbo
     * @date 2018年6月30日
     */
    boolean tryLock(String lockKey, String lockValue, int lockSeconds, long tryIntervalMillis, int maxTryCount);
    
    void unLock(String lockKey, String lockValue);
}

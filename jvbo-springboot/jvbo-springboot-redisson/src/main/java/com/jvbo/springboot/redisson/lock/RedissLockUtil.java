/*
 * RedissLockUtil.java 2018年6月30日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.redisson.lock;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;

public class RedissLockUtil {
    private static RedissonDistributedLock redissLock;
    
    public static void setLock(RedissonDistributedLock lock) {
        redissLock = lock;
    }
    
    public static RLock lock(String lockKey) {
        return redissLock.lock(lockKey);
    }

    public static void unlock(String lockKey) {
        redissLock.unlock(lockKey);
    }
    
    public static void unlock(RLock lock) {
        redissLock.unlock(lock);
    }

    /**
     * 带超时的锁
     * @Description: TODO
     * @param @param lockKey
     * @param @param unit
     * @param @param timeout
     * @param @return   
     * @return RLock  
     * @throws
     * @author jvbo
     * @date 2018年6月30日
     */
    public static RLock lock(String lockKey, TimeUnit unit ,int timeout) {
        return redissLock.lock(lockKey, unit, timeout);
    }
    
    /**
     * 尝试获取锁
     * @Description: TODO
     * @param @param lockKey
     * @param @param waitTime 最多等待时间
     * @param @param leaseTime 上锁后自动释放锁时间
     * @param @return   
     * @return boolean  
     * @throws
     * @author jvbo
     * @date 2018年6月30日
     */
    public static boolean tryLock(String lockKey, int waitTime, int leaseTime) {
        return redissLock.tryLock(lockKey, TimeUnit.SECONDS, waitTime, leaseTime);
    }
    
    /**
     * 尝试获取锁
     * @Description: TODO
     * @param @param lockKey
     * @param @param unit 时间单位
     * @param @param waitTime 最多等待时间
     * @param @param leaseTime 上锁后自动释放锁时间
     * @param @return   
     * @return boolean  
     * @throws
     * @author jvbo
     * @date 2018年6月30日
     */
    public static boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime) {
        return redissLock.tryLock(lockKey, unit, waitTime, leaseTime);
    }
}

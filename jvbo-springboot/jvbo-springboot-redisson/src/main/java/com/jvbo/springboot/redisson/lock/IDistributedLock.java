/*
 * IDistributedLock.java 2018年6月30日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.redisson.lock;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;

public interface IDistributedLock {
    RLock lock(String lockKey);

    RLock lock(String lockKey, TimeUnit unit, int timeout);

    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);

    void unlock(String lockKey);

    void unlock(RLock lock);
}

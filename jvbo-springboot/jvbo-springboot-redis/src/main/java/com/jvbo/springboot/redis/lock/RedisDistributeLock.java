/*
 * RedisDistributeLock.java 2018年6月29日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.redis.lock;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

@Component
public class RedisDistributeLock implements IDistributeLock {
    
    private static final Logger logger = LoggerFactory.getLogger(RedisDistributeLock.class);
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    /**
     * 使用脚本在redis服务器执行此逻辑可以在一定程度上保证此操作的原子性
     * (即不会发生客户端在执行setNx和expire命令之间发生崩溃或失去与服务器的连接导致expire
     * 没有得到执行,发生永久死锁)
     * 如果在redis服务器执行时服务器崩溃,锁也会失效;
     */
    private static final RedisScript<Boolean> SETNX_AND_EXPIRE_SCRIPT;
    /**
     * 
     */
    private static final RedisScript<Boolean> DEL_IF_GET_EQUALS;

    static {
        StringBuilder setNxAndExpire = new StringBuilder();
        setNxAndExpire.append("if (redis.call('setnx', KEYS[1], ARGV[1]) == 1) then\n");
        setNxAndExpire.append("\tredis.call('expire', KEYS[1], tonumber(ARGV[2]))\n");
        setNxAndExpire.append("\treturn true\n");
        setNxAndExpire.append("else\n");
        setNxAndExpire.append("\treturn false\n");
        setNxAndExpire.append("end");
        SETNX_AND_EXPIRE_SCRIPT = new RedisScriptImpl<Boolean>(setNxAndExpire.toString(), Boolean.class);
        
        StringBuilder delGetEquals = new StringBuilder();
        delGetEquals.append("if (redis.call('get', KEYS[1]) == ARGV[1]) then\n");
        delGetEquals.append("\tredis.call('del', KEYS[1])\n");
        delGetEquals.append("\treturn true\n");
        delGetEquals.append("else\n");
        delGetEquals.append("\treturn false\n");
        delGetEquals.append("end");
        DEL_IF_GET_EQUALS = new RedisScriptImpl<Boolean>(delGetEquals.toString(), Boolean.class);
    }
    
    private boolean doTryLock(String lockKey, String lockValue, int lockSeconds) throws Exception {
        boolean locked = redisTemplate.hasKey(lockKey);
        if (locked) {
            throw new IllegalStateException("already locked");
        }
        locked = redisTemplate.execute(SETNX_AND_EXPIRE_SCRIPT, Collections.singletonList(lockKey), lockValue,
                                             String.valueOf(lockSeconds));
        return locked;
    }
    
    @Override
    public boolean tryLock(String lockKey, String lockValue) {
        return tryLock(lockKey, lockValue, 0);
    }

    @Override
    public boolean tryLock(String lockKey, String lockValue, int lockSeconds) {
        try {
            return doTryLock(lockKey, lockValue, lockSeconds);
        } catch (Exception e) {
            logger.error("tryLock Error", e);
            return false;
        }
    }

    @Override
    public boolean tryLock(String lockKey, String lockValue, int lockSeconds, long tryIntervalMillis, int maxTryCount) {
        int tryCount = 0;
        while (true) {
            if (++tryCount >= maxTryCount) {
                // 获取锁超时
                return false;
            }
            try {
                if (doTryLock(lockKey, lockValue, lockSeconds)) {
                    return true;
                }
            } catch (Exception e) {
                logger.error("tryLock Error", e);
                return false;
            }
            try {
                Thread.sleep(tryIntervalMillis);
            } catch (InterruptedException e) {
                logger.error("tryLock interrupted", e);
                return false;
            }
        }
    }

    @Override
    public void unLock(String lockKey, String lockValue) {
        boolean locked = redisTemplate.hasKey(lockKey);
        if (!locked) {
            throw new IllegalStateException("not locked yet!");
        }
        // 忽略结果
        redisTemplate.execute(DEL_IF_GET_EQUALS, Collections.singletonList(lockKey), lockValue);
    }
    
    private static class RedisScriptImpl<T> implements RedisScript<T> {
        private final String sha1;
        private final Class<T> resultType;
        private final String scriptAsString;
        
        public RedisScriptImpl(String scriptAsString, Class<T> resultType){
            this.sha1 = DigestUtils.sha1DigestAsHex(scriptAsString);
            this.resultType = resultType;
            this.scriptAsString = scriptAsString;
        }
        
        @Override
        public String getSha1() {
            return sha1;
        }

        @Override
        public Class<T> getResultType() {
            return resultType;
        }

        @Override
        public String getScriptAsString() {
            return scriptAsString;
        }
        
    }
}

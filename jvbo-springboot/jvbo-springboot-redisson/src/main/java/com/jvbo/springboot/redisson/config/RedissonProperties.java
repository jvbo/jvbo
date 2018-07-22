/*
 * RedissonProperties.java 2018年6月30日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.redisson.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "redisson")
public class RedissonProperties {
    private String address;
    private String password;
    private int connectionMinimumIdleSize=32;
    private int connectionPoolSize = 64;
    private int database = 0;
    
    private int timeout = 3000;
    private int slaveConnectionPoolSize = 250;
    private int masterConnectionPoolSize = 250;
    private String[] sentinelAddresses;
    private String masterName;
    
    
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the connectionMinimumIdleSize
     */
    public int getConnectionMinimumIdleSize() {
        return connectionMinimumIdleSize;
    }
    /**
     * @param connectionMinimumIdleSize the connectionMinimumIdleSize to set
     */
    public void setConnectionMinimumIdleSize(int connectionMinimumIdleSize) {
        this.connectionMinimumIdleSize = connectionMinimumIdleSize;
    }
    /**
     * @return the connectionPoolSize
     */
    public int getConnectionPoolSize() {
        return connectionPoolSize;
    }
    /**
     * @param connectionPoolSize the connectionPoolSize to set
     */
    public void setConnectionPoolSize(int connectionPoolSize) {
        this.connectionPoolSize = connectionPoolSize;
    }
    /**
     * @return the database
     */
    public int getDatabase() {
        return database;
    }
    /**
     * @param database the database to set
     */
    public void setDatabase(int database) {
        this.database = database;
    }
    /**
     * @return the timeout
     */
    public int getTimeout() {
        return timeout;
    }
    /**
     * @param timeout the timeout to set
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    /**
     * @return the slaveConnectionPoolSize
     */
    public int getSlaveConnectionPoolSize() {
        return slaveConnectionPoolSize;
    }
    /**
     * @param slaveConnectionPoolSize the slaveConnectionPoolSize to set
     */
    public void setSlaveConnectionPoolSize(int slaveConnectionPoolSize) {
        this.slaveConnectionPoolSize = slaveConnectionPoolSize;
    }
    /**
     * @return the masterConnectionPoolSize
     */
    public int getMasterConnectionPoolSize() {
        return masterConnectionPoolSize;
    }
    /**
     * @param masterConnectionPoolSize the masterConnectionPoolSize to set
     */
    public void setMasterConnectionPoolSize(int masterConnectionPoolSize) {
        this.masterConnectionPoolSize = masterConnectionPoolSize;
    }
    /**
     * @return the sentinelAddresses
     */
    public String[] getSentinelAddresses() {
        return sentinelAddresses;
    }
    /**
     * @param sentinelAddresses the sentinelAddresses to set
     */
    public void setSentinelAddresses(String[] sentinelAddresses) {
        this.sentinelAddresses = sentinelAddresses;
    }
    /**
     * @return the masterName
     */
    public String getMasterName() {
        return masterName;
    }
    /**
     * @param masterName the masterName to set
     */
    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }
}

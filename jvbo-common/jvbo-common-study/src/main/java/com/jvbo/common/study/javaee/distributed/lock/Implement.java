/*
 * Implement.java 2018年1月8日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javaee.distributed.lock;

/**
 * 分布式锁实现
 * @ClassName: Implement 
 * {@link http://www.cnblogs.com/wade-luffy/p/5812335.html}
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月8日
 */
public class Implement {
	/**
	 * 分布式锁解决方式
	 * 1. 基于数据库表做乐观锁; @see #database
	 * 2. 使用memcached的add方法; @see #memecachedAdd
	 * 3. 使用memcached的cas()方法;(不常用)
	 * 4. 使用redis的setnx(),expire()方法;@see #redisSetnxExpire
	 * 5. 使用redis的setnx(),get(),getset()方法;@see #redisSetnxGetGetset
	 * 6. 使用redis的watch,multi,exec命令;(不常用)
	 * 7. 使用zookeeper;(不常用)
	 */
	public static void main(String[] args) {
		
	}
	
	public static void database(){
		/**
		 * t_user
		 * +-------------------------------------------------------------+
		 * id  name  state  gmt_created  gmt_modified  is_deleted  version
         * +-------------------------------------------------------------+
		 * 11  1234    1    15299999999  15299999999       0          55
         * +-------------------------------------------------------------+
         * 12  1235    1    15299999999  15299999999       0          55
         * +-------------------------------------------------------------+
         * 
         * 根据version字段，先查询，后修改。
		 */
	}
	
	public static void memecachedAdd(){
		
	}
	
	public static void redisSetnxExpire(){
		
	}
	
	public static void redisSetnxGetGetset(){
		
	}
}

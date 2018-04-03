/*
 * Demo.java 2017年8月26日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm;

public class JvmExcuteProcess {
	 
	int i  = 0;
	public int getNextId(){
		return i++;
	}
	
	/**
	 * JVM中执行步骤
	 * 1.JVM首先在main memory(JVM堆)给分配一个内存存储场所，并存储其值；
	 * 2.线程启动后，会自动分配一片working memory区(通常是操作数栈),当线程执行到reuturn i++时，
	 * jvm并不是简单的一个步骤就可以完成的。i++动作在jvm中分为装在i、读取i、进行i+1操作、
	 * 存储i及写入i五个步骤才得以完成。
	 *   a.装载i
	 *   线程发起一个装载i的请求给jvm线程执行引擎，引擎接受请求后会向main memory发起一个
	 *   read i的指令。当read i执行完毕后，一段时间会将i的值从main memory区复制到working memory区中。
	 *   b.读取i
	 *   负责从main memory中读取i;
	 *   c.进行i+1操作
	 *   此步由线程完成。
	 *   d.存储i
	 *   将i+1的值赋给i,然后存储到working memory中
	 *   e.写入i
	 *   一段时间后i的值会写回到main memory中。
	 */
	
}

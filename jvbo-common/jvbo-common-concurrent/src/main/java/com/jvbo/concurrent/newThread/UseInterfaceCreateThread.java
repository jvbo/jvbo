/*
 * UseInterfaceCreateThread.java 2017年6月22日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: UseInterfaceCreateThread.java
 * @Package com.jvbo.concurrent.interface2thread
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月22日
 */
package com.jvbo.concurrent.newThread;

/**  
 * 实现Runnable新建线程
 * @ClassName: UseInterfaceCreateThread 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月22日
 */
public class UseInterfaceCreateThread implements Runnable {

	/**
	 * @Description: TODO
	 * @param    
	 * @return  
	 * @throws
	 * @author jvbo
	 * @date 2017年6月22日
	 */
	public void run() {
		System.out.println("hello, i am a thread");
	}

	/**
	 * @Description: TODO
	 * @param @param args   
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年6月22日
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(new UseInterfaceCreateThread());
		t1.start();
	}

}

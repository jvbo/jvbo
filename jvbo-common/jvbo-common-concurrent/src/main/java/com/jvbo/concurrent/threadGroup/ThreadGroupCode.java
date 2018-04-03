/*
 * ThreadGroup.java 2017年6月24日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: ThreadGroup.java
 * @Package com.jvbo.concurrent.threadGroup
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月24日
 */
package com.jvbo.concurrent.threadGroup;

/**  
 * @ClassName: ThreadGroup 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月24日
 */
public class ThreadGroupCode implements Runnable{

	/**
	 * @Description: TODO
	 * @param @param args   
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年6月24日
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup tg = new ThreadGroup("printGroup");
		Thread t1 = new Thread(tg, new ThreadGroupCode(), "T1");
		Thread t2 = new Thread(tg, new ThreadGroupCode(), "T2");
		t1.start();
		t2.start();
		System.out.println(tg.activeCount());
		tg.list();
	}

	/**
	 * @Description: TODO
	 * @param    
	 * @return  
	 * @throws\=
	 * @author jvbo
	 * @date 2017年6月24日
	 */
	public void run() {
		// TODO Auto-generated method stub
		String groupAndName = Thread.currentThread().getThreadGroup().getName()
				+ "-" + Thread.currentThread().getName();
		while(true){
			System.out.println("i am" + groupAndName);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

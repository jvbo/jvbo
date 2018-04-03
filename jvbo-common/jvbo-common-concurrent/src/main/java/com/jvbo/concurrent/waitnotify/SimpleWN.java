/*
 * WaitNotify.java 2017年6月24日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: WaitNotify.java
 * @Package com.jvbo.concurrent.waitnotify
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月24日
 */
package com.jvbo.concurrent.waitnotify;

/**  
 * @ClassName: WaitNotify 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月24日
 */
public class SimpleWN {
	/*Object.wait()和Thread.sleep()方法都可以让线程等待若干时间，
	 * 除了wait()可以被唤醒外，另一个主要区别是wait()方法会释放目标对象的锁，
	 * 而Thread.sleep()方法不会释放任何资源*/
	final static Object object = new Object();
	public static class T1 extends Thread{
		public void run(){
			synchronized(object){
				System.out.println(System.currentTimeMillis() + ":T1 start");
				try {
					System.out.println(System.currentTimeMillis() + "T1 wait for object");
					object.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis() + "T1 end");
			}
		}
	}
	
	public static class T2 extends Thread{
		public void run(){
			synchronized(object){
				System.out.println(System.currentTimeMillis() + "T2 start notify one thread");
				object.notify();
				System.out.println(System.currentTimeMillis() + "T2 end");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

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
		Thread t1 = new T1();
		Thread t2 = new T2();
		t1.start();
		t2.start();
	}

}

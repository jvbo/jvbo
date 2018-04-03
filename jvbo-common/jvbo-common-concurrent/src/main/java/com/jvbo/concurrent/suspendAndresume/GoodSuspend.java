/*
 * GoodSuspend.java 2017年6月24日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: GoodSuspend.java
 * @Package com.jvbo.concurrent.suspendAndresume
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月24日
 */
package com.jvbo.concurrent.suspendAndresume;

/**  
 * @ClassName: GoodSuspend 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月24日
 */
public class GoodSuspend {
	/*不推荐使用suspend()和resume()方法，suspend()在导致线程暂停时，不会释放任务锁资源，
	 * 此时，其他线程想要访问被它占用的锁，都会被牵连，导致无法正常继续运行，知道对应线程进行resume()操作，
	 * 被挂起的线程才能继续，从而其他所有相关锁上的线程也可以继续执行。但是，如果resume()操作意外的在suspend()之前执行了，
	 * 那么被挂起的线程可能很难有机会被继续执行。并且，更严重的是：它锁占用的锁不会被释放，因此可能会导致整个系统工作不正常，
	 * 而且，对于被挂起的线程，从它的线程状态上来看，居然还是Runnable状态，这也会严重影响我们对系统当前状态的判断；*/
	public static Object u = new Object();
	
	public static class ChangeObjectThread extends Thread{
		volatile boolean suspendme = false;
		public void suspendMe(){
			System.out.println("suspendMe");
			suspendme = true;
		}
		
		public void resumeMe(){
			System.out.println("resumeMe");
			suspendme = false;
			synchronized(this){
				System.out.println("notify");
				notify();
			}
		}
		
		@Override
		public void run(){
			while(true){
				synchronized(this){
					System.out.println(suspendme);
					while(suspendme){
						try {
							System.out.println("wait");
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				synchronized(u){
					System.out.println("in ChangeObjectThread");
				}
				Thread.yield();
			}
		}
	}
	
	public static class ReadObjectThread extends Thread{
		@Override
		public void run(){
			while(true){
				synchronized(u){
					System.out.println("in ReadObjectThread");
				}
				Thread.yield();
			}
		}
	}
	/**
	 * @Description: TODO
	 * @param @param args   
	 * @return void  
	 * @throws InterruptedException 
	 * @throws
	 * @author jvbo
	 * @date 2017年6月24日
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChangeObjectThread t1 = new ChangeObjectThread();
		ReadObjectThread t2 = new ReadObjectThread();
		t1.start();
		t2.start();
		Thread.sleep(1000);
		t1.suspendMe();
		System.out.println("suspend t1 2 sec");
		Thread.sleep(2000);
		System.out.println("resume t1");
		t1.resumeMe();
	}

}

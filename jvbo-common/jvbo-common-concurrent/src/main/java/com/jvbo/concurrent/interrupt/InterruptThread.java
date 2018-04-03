/*
 * InterruptThread.java 2017年6月24日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: InterruptThread.java
 * @Package com.jvbo.concurrent.interrupt
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月24日
 */
package com.jvbo.concurrent.interrupt;

/**  
 * @ClassName: InterruptThread 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月24日
 */
public class InterruptThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					//中断处理逻辑
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Thread interrupt");
						break;
					}
					Thread.yield();
				}
			}
		};
		t1.start();
		Thread.sleep(2000);
		t1.interrupt();/*通知目标线程中断，即设置中断标志位，
		但是必须在目标线程中进行中断处理逻辑,否则不会有任何作用*/
	}
}

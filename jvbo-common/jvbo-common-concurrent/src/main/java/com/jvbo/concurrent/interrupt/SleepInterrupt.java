/*
 * SleepInterrupt.java 2017年6月24日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: SleepInterrupt.java
 * @Package com.jvbo.concurrent.interrupt
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月24日
 */
package com.jvbo.concurrent.interrupt;

/**  
 * @ClassName: SleepInterrupt 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月24日
 */
public class SleepInterrupt {

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
		/*Thread.sleep()方法由于中断而抛出异常，此时会清除中断标记，如果不加处理，
		 * 那么下一次循环开始时，就无法捕捉这个中断，故在异常处理中，再次设置中断标记位*/
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("thread interrupt");
						break;
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("interrup when sleep");
						Thread.currentThread().interrupt();
					}
					Thread.yield();
				}
				
			}
		};
		t1.start();
		Thread.sleep(2000);
		t1.interrupt();
	}

}

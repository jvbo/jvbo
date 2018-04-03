/*
 * VolatileNotAtomicity.java 2017年6月24日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: VolatileNotAtomicity.java
 * @Package com.jvbo.concurrent.volatileIsAtomicity
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月24日
 */
package com.jvbo.concurrent.volatileIsAtomicity;

/**  
 * @ClassName: VolatileNotAtomicity 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月24日
 */
public class VolatileNotAtomicity {
	/*volatile不能代替锁，也无法保证一些符合操作的原子性*/
	static volatile int i = 0;
	public static class PlusTask extends Thread{
		@Override 
		public void run(){
			for (int k = 0; k < 10000; k++) {
				i++;
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
		Thread[] threadArr = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threadArr[i] = new Thread(new PlusTask());
			threadArr[i].start();
		}
		for (int i = 0; i < 10; i++) {
			threadArr[i].join();
		}
		System.out.println(i);
	}

}

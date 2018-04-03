/*
 * MultiThreadLong.java 2017年6月22日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: MultiThreadLong.java
 * @Package com.jvbo.concurrent.atomicity
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月22日
 */
package com.jvbo.concurrent.atomicity;

/**
 * 原子性验证
 * @ClassName: MultiThreadLong 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月22日
 */
public class MultiThreadLong {
	/*long有64位，对于32位系统来说，long的读写不是原子性的，
	 * 即多个线程同时对long进行写入或读取，线程之间的结果会有误*/
	public static long t = 0;
	public static class ChangeT implements Runnable{
		private long to;
		public ChangeT(long to){
			this.to = to;
		}

		public void run() {
			while(true){
				MultiThreadLong.t = to;
				Thread.yield();//线程让步
			}
		}
	}

	public static class ReadT implements Runnable{

		public void run(){
			while(true){
				long temp = MultiThreadLong.t;
				if(temp != 111L && temp != -999L && temp != 333L && temp != -444L)
					System.out.println(temp);
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new ChangeT(111L)).start();
		new Thread(new ChangeT(-999L)).start();
		new Thread(new ChangeT(333L)).start();
		new Thread(new ChangeT(-444L)).start();
		new Thread(new ReadT()).start();
	}
}

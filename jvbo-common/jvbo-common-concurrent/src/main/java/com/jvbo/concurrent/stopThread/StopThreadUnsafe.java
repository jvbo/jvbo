/*
 * StopThreadUnsafe.java 2017年6月22日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: StopThreadUnsafe.java
 * @Package com.jvbo.concurrent.stopThread
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月22日
 */
package com.jvbo.concurrent.stopThread;

/**  
 * 错误停止线程案例(错误案例)
 * @ClassName: StopThreadUnsafe 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月22日
 */
public class StopThreadUnsafe {
	/*stop()方法在结束线程时，会直接终止线程，立即释放这个线程所持有的锁，
	 * 这些锁恰恰是维持对象一致性的，如果此时写线程写入数据正写到一半，并强行终止，
	 * 那么对象会被写坏，同时，由于锁已经释放，另外一个等待该锁的读线程就会读到这个不一致的对象*/
	public static class User{
		private int id;
		private String name;
		public User(){
			id = 0;
			name = "0";
		}
		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + "]";
		}
	}
	
	public static User u = new User();
	
	public static class ChangeObjectThread extends Thread{
		@Override
		public void run() {
			while(true){
				synchronized(u){
					int v = (int)(System.currentTimeMillis()/1000);
					u.setId(v);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					u.setName(String.valueOf(v));
				}
				Thread.yield();
			}
		}
	}
	
	public static class ReadObjectThread extends Thread{
		@Override
		public void run() {
			while(true){
				synchronized(u){
					if(u.getId() != Integer.parseInt(u.getName())){
						System.out.println(u.toString());
					}
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
	 * @date 2017年6月22日
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		new ReadObjectThread().start();
		while(true){
			Thread t = new ChangeObjectThread();
			t.start();
			Thread.sleep(150);
			t.stop();
		}
			
	}
	
}

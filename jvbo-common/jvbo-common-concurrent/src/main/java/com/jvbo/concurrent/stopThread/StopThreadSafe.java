/*
 * StopThreadSafe.java 2017年6月22日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: StopThreadSafe.java
 * @Package com.jvbo.concurrent.stopThread
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月22日
 */
package com.jvbo.concurrent.stopThread;

/**  
 * @ClassName: StopThreadSafe 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月22日
 */
public class StopThreadSafe {
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
		volatile boolean stopme = false;
		public void stopMe(){
			stopme = true;
		}
		@Override
		public void run() {
			while(true){
				if(stopme){
					System.out.println("exit by stop me");
					break;
				}
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
					System.out.println(u.toString());
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
	public static void main(String[] args) throws InterruptedException {
		new ReadObjectThread().start();
		while(true){
			ChangeObjectThread cot = new ChangeObjectThread();
			Thread t = cot;
			t.start();
			Thread.sleep(150);
			cot.stopMe();
		}
			
	}

}
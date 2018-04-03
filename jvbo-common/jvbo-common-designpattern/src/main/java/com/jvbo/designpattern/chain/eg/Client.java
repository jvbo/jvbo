/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.chain.eg;

/**
 * 责任链模式-客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	public static void main(String[] args) {
		Handler h1 = new GeneralManager();
		Handler h2 = new DeptManager();
		Handler h3 = new ProjectManager();
		h3.setSuccessor(h2);
		h2.setSuccessor(h1);
		
		//测试
		String test1 = h3.handlerFeeRequest("张三", 300);
        System.out.println("test1 = " + test1);
        String test2 = h3.handlerFeeRequest("李四", 300);
        System.out.println("test2 = " + test2);
        System.out.println("----");
        
        String test3 = h3.handlerFeeRequest("张三", 700);
        System.out.println("test3 = " + test3);
        String test4 = h3.handlerFeeRequest("李四", 700);
        System.out.println("test4 = " + test4);
        System.out.println("----");
        
        String test5 = h3.handlerFeeRequest("张三", 1500);
        System.out.println("test5 = " + test5);
        String test6 = h3.handlerFeeRequest("李四", 1500);
        System.out.println("test6 = " + test6);
	}
}

/**
 * 1.纯的与不纯的责任链模式
 * a.一个纯的责任链模式要求一个具体的处理者对象只能在两个行为中选择一个:一是承担责任,
 * 而是把责任推给下家;不允许出现某一个具体处理者对象在承担了一部分责任后又把责任向下传的情况
 * b.在一个纯的责任链模式里面,一个请求必须被某一个处理者对象所接收;
 * 在一个不纯的责任链模式里面,一个请求可以最终不被任何接收端对象所接收;
 * c.纯的责任链模式的实际例子很难找到,一般看到的例子均是不纯的责任链模式的实现;
 * 有些人认为不纯的责任链根本不是责任链模式,这也许是有道理的;
 * 但是在实际的系统里,纯的责任链很难找到;如果坚持责任链不纯便不是责任链模式,
 * 那么责任链模式便不会有太大意义;
 */

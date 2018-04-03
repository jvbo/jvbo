/*
 * Client.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.mediator.eg;

/**
 * 调停者模式-客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Client {
	public static void main(String[] args) {
		//创建调停者-主板
        MainBoard mediator = new MainBoard();
        //创建同事类
        CDDriver cd = new CDDriver(mediator);
        CPU cpu = new CPU(mediator);
        VideoCard vc = new VideoCard(mediator);
        SoundCard sc = new SoundCard(mediator);
        //让调停者知道所有同事
        mediator.setCdDriver(cd);
        mediator.setCpu(cpu);
        mediator.setVideoCard(vc);
        mediator.setSoundCard(sc);
        //开始看电影,把光盘放入光驱,光驱开始读盘
        cd.readCD();
	}
}

/**
 * 调停者模式的优点:
 * 1.松散耦合:调停者模式通过把多个同事对象之间的交互封装到调停者对象里面,
 * 从而使得同事对象之间松散耦合,基本上可以做到互补依赖;
 * 这样一来,同事对象就可以独立地变化和复用,而不再像以前那样"牵一处而动全身"了;
 * 2.集中控制交互:多个同事对象的交互,
 * 被封装在调停者对象里面集中管理,使得这些交互行为发生变化的时候,
 * 只需要修改调停者对象就可以了,当然如果是已经做好的系统,那么就扩展调停者对象,
 * 而各个同事类不需要做修改;
 * 3.多对多变成一对多:没有使用调停者模式的时候,
 * 同事对象之间的关系通常是多对多的,引入调停者对象以后,
 * 调停者对象和同事对象的关系通常变成双向的一对多,这会让对象的关系更容易理解和实现;
 * 
 * 调停者模式的缺点:调停者模式的一个潜在缺点是,过度集中化;
 * 如果同事对象的交互非常多,而且比较复杂,当这些复杂性全部集中到调停者的时候,
 * 会导致调停者对象变得十分复杂,而且难于管理和维护;
 */

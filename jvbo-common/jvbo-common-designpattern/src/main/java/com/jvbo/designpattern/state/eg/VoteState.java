/*
 * VoteState.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.state.eg;

/**
 * 抽象状态接口
 * @ClassName: VoteState 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public interface VoteState {
	/**
	 * 处理状态对应的行为
	 * @Description: TODO
	 * @param @param user 投票人
	 * @param @param voteItem 投票项
	 * @param @param voteManager 投票上下文,用来在实现状态对应的功能处理的时候,可以回调上下文的数据
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年11月13日
	 */
    void vote(String user,String voteItem,VoteManager voteManager);
}

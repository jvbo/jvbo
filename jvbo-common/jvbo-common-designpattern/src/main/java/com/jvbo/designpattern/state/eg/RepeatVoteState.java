/*
 * RepeatVoteState.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.state.eg;

/**
 * 具体状态类-重复投票
 * @ClassName: RepeatVoteState 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class RepeatVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		//重复投票，暂时不做处理
        System.out.println("请不要重复投票");
	}

}

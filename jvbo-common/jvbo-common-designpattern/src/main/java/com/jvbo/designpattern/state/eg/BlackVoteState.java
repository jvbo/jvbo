/*
 * BlackVoteState.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.state.eg;

/**
 * 具体状态类-黑名单
 * @ClassName: BlackVoteState 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class BlackVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		//记录黑名单中，禁止登录系统
        System.out.println("进入黑名单,将禁止登录和使用本系统");
	}

}

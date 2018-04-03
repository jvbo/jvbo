/*
 * NormalVoteState.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.state.eg;

/**
 * 具体状态类-正常投票
 * @ClassName: NormalVoteState 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class NormalVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		//正常投票，记录到投票记录中
        voteManager.getMapVote().put(user, voteItem);
        System.out.println("恭喜投票成功");
	}

}

/*
 * SpiteVoteState.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.state.eg;

/**
 * 具体状态类-恶意刷票
 * @ClassName: SpiteVoteState 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class SpiteVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		// 恶意投票，取消用户的投票资格，并取消投票记录
        String str = voteManager.getMapVote().get(user);
        if(str != null){
            voteManager.getMapVote().remove(user);
        }
        System.out.println("你有恶意刷屏行为，取消投票资格");
	}

}

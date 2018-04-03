/*
 * DeptManager.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.chain.eg;

/**
 * 具体处理者角色
 * @ClassName: DeptManager 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class DeptManager extends Handler {

	@Override
	public String handlerFeeRequest(String user, double fee) {
		String str = "";
		if(fee < 1000){
			if("张三".equals(user)){
				str = "成功: 部门经理同意-" + user +"-的申请,金额:" + fee +"元";
			}else{
				str = "失败: 部门经理不同意-" + user +"-的申请,金额:" + fee +"元";
			}
		}else{
			if(getSuccessor() != null){
				return getSuccessor().handlerFeeRequest(user, fee);
			}
		}
		return str;
	}

}

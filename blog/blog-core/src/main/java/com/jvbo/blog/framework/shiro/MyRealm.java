/*
 * MyRealm.java 2016年10月16日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.framework.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.jvbo.blog.model.User;
import com.jvbo.blog.service.admin.system.ISysUserService;

/**
 * JvboBlogRealm
 * @ClassName: MyRealm 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月16日
 */
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private ISysUserService userService;
	
	/**
	 * 为当限前登录的用户授予角色和权(权限验证)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 验证当前登录的用户(登录认证)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String loginName = (String)token.getPrincipal();
		User user = userService.findByLoginName(loginName);
		if(user!=null){
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", user); // 当前用户信息存到session中
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getLoginName(),user.getPassWord(),"xx");
			return authcInfo;
		}else{
			return null;				
		}
	}

}

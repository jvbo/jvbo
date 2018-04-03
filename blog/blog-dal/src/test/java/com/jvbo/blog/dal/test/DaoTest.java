///*
// * UserTest.java 2016年10月14日
// * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
// */
///**  
// * @Title: UserTest.java
// * @Package com.jvbo.blog.dal.test
// * @Description: TODO
// * @author jvbo
// * @date 2016年10月14日
// */
//package com.jvbo.blog.dal.test;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.jvbo.blog.dao.admin.UserMapper;
//import com.jvbo.blog.model.User;
//import com.jvbo.blog.model.UserExample;
//import com.jvbo.framework.mybatis.pageplugin.Page;
//
///**
// * @ClassName: DaoTest 
// * @Description: TODO
// * @author jvbo
// * @date 2016年10月14日
// */
//@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:application-test.xml"})
//@TransactionConfiguration(defaultRollback=true)
//@Transactional
//public class DaoTest {
//	
//	@Autowired
//	private UserMapper userMapper;
//	
//	@Before
//	public void insertUserTest() throws Exception {
//		for (int i = 5; i < 100; i++) {
//			User user = new User();
//			user.setId(String.valueOf(i));
//			user.setLoginName(String.valueOf(i));
//			user.setPassWord(String.valueOf(i));
//			user.setAddUserId(String.valueOf(i));
//			userMapper.insertSelective(user);
//		}
//	}
//	
//	@Test
//	public void selectUserListTest() throws Exception{
//		UserExample example = new UserExample();
//		Page page = new Page();
//		//page.setPageNo(3);
//		page.setBegin(0);
//		Long totalRecords = userMapper.countByExample(example);
//		page.setTotalRecords(totalRecords.intValue());
//		example.setPage(page);
//		System.err.println(page.toString());
//		List<User> userList = userMapper.selectByExample(example);
//		System.out.println(userList);
//	}
//	
//}

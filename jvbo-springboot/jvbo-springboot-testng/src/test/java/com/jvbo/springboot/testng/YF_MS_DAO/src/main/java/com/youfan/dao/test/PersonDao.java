package com.youfan.dao.test;

import com.youfan.enity.test.Person;

public interface PersonDao {
	public Person querypersonbyid(int id);
	public void inserperson(Person person);
}

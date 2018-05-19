package com.youfan.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youfan.dao.test.PersonDao;
import com.youfan.enity.test.Person;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	PersonDao personDao;
	
	public Person querypersonbyid(int id){
		return personDao.querypersonbyid(id);
	}
	
	
	public void inserperson(Person person){
		personDao.inserperson(person);
	}
}

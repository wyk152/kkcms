package com.gdut.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.gdut.test.entity.Person;
import com.gdut.test.service.TestService;

/**
 * 
 * @author wyk
 * @time 2016年6月1日
 */
@Service("testService")
public class testServiceImpl implements TestService {

	/*@Resource
	BaseDao<Person> testdao;*/
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("hello:service.....");
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person findById(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Person> findObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	@Override
	public Person findById(String id) {
		// TODO Auto-generated method stub
		return (Person) testdao.findById(id);
	}

	@Override
	public void save(Person entity) {
		// TODO Auto-generated method stub
		testdao.save(entity);
	}

	@Override
	public Person find( String id) {
		// TODO Auto-generated method stub
		return null;
	}*/



}

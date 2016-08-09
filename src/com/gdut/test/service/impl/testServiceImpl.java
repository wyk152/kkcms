package com.gdut.test.service.impl;

import org.springframework.stereotype.Service;

import org.wyk.main.service.impl.BaseServiceImpl;

import com.gdut.test.entity.Person;
import com.gdut.test.service.TestService;

/**
 * 
 * @author wyk
 * @time 2016年6月1日
 */
@Service("testService")
public class testServiceImpl extends BaseServiceImpl<Person> implements TestService {

	/*@Resource
	BaseDao<Person> testdao;*/
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("hello:service.....");
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

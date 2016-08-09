package com.gdut.test.service;

import org.wyk.main.service.BaseService;

import com.gdut.test.entity.Person;


/**
 * 
 * @author wyk
 * @time 2016年6月1日
 */
public interface TestService extends BaseService<Person>{

	public abstract void say();
	/*public void save(T entity);
	public Person find(String id);
	public Person findById(String id);*/
}

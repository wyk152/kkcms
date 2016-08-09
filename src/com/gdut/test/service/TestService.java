package com.gdut.test.service;

import java.util.List;

import com.gdut.test.entity.Person;


/**
 * 
 * @author wyk
 * @time 2016年6月1日
 */
public interface TestService{

	public abstract void say();
	/*public void save(T entity);
	public Person find(String id);
	public Person findById(String id);*/

	public abstract void deleteById(String id);

	public abstract Person findById(String string);

	public abstract void save(Person person);

	public abstract void update(Person p);

	public abstract List<Person> findObjects();
}

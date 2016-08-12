package com.gdut.test.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wyk.main.dao.Impl.BaseDaoImpl;
import org.wyk.nsfw.user.entity.User;

import com.gdut.test.dao.TestDao;
import com.gdut.test.entity.Person;


/**
 * 测试Dao
 * @author wyk
 * @time 2016年6月1日
 */
public class TestDaoImpl extends BaseDaoImpl<Person> implements TestDao {

	public void save(Person entity) {
		// TODO Auto-generated method stu
		getHibernateTemplate().save(entity);
	}
}

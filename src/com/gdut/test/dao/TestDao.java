package com.gdut.test.dao;

import org.wyk.main.dao.BaseDao;
import org.wyk.nsfw.user.entity.User;

import com.gdut.test.entity.Person;


/**
 * 测试用dao实现层
 * @author wyk
 * @time 2016年6月1日
 */
public interface TestDao extends BaseDao<Person>{

	public void save(Person entity);
}

package com.gdut.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.wyk.main.service.impl.BaseServiceImpl;
import org.wyk.nsfw.user.entity.User;

import com.gdut.test.dao.TestDao;
import com.gdut.test.entity.Person;
import com.gdut.test.service.TestService;

/**
 * 
 * @author wyk
 * @time 2016年6月1日
 */
/**
 * @author wangyankai
 *
 */
@Service("testService")
public class testServiceImpl implements TestService {

	@Resource
	TestDao testDao;

	public void save(Person entity) {
		// TODO Auto-generated method stub
		testDao.save(entity);
	}

}

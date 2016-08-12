package org.wyk.main.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.wyk.main.dao.BaseDao;
import org.wyk.main.service.BaseService;
import org.wyk.main.util.PageResult;
import org.wyk.main.util.QueryHelper;

public class BaseServiceImpl<T> implements BaseService <T>{

	//@Autowired
	private BaseDao<T> baseDao;
	
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		baseDao.save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		baseDao.update(entity);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		baseDao.delete(id);
	}

	@Override
	public T findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.findObjectById(id);
	}

	@Override
	public List<T> findObjects() {
		// TODO Auto-generated method stub
		return baseDao.findObjects();
	}

	@Override
	public List<T> findObjectsList(QueryHelper queryHelper) {
		// TODO Auto-generated method stub
		return baseDao.findObjectsList(queryHelper);
	}

	@Override
	public PageResult findObjectsList(QueryHelper queryHelper, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return baseDao.findObjectsList(queryHelper, pageNo, pageSize);
	}
	

}

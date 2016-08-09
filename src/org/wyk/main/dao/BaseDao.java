package org.wyk.main.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author wyk
 * @time 2016年6月1日
 */
public interface BaseDao<T> {
	
	public  void save(T entity);
	
	public  void update(T entity);
	
	public void delete(Serializable id);
	
	public T findById(Serializable id);
	public  List<T> findObjects();

	
}

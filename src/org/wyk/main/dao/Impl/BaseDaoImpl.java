package org.wyk.main.dao.Impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wyk.main.dao.BaseDao;

/**
 * dao基类实现类
 * @author wyk
 * @time 2016年6月1日
 */
public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

	private Class<T> clazz;
	
	/**
	 *	获取泛型类型，
	 *	通过反射得到T的真实类型
	 *  @time 2016年6月1日
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		System.out.println(this.getClass().getGenericSuperclass()+"--LLC");
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(Serializable id) {
		getHibernateTemplate().delete(findObjectById(id));
	}

	@Override
	public T findObjectById(Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> findObjects() {
		Query query = getSession().createQuery("FROM " + clazz.getSimpleName());
		return query.list();
	}
	

}

package org.wyk.main.dao.Impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wyk.main.dao.BaseDao;
import org.wyk.main.util.PageResult;
import org.wyk.main.util.QueryHelper;
import org.wyk.nsfw.info.entity.Info;

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

	@Override
	public List<T> findObjectsList(QueryHelper queryHelper) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(queryHelper.getQueryListHql());
		List<Object> parm = queryHelper.getParameters();
		if(parm != null){
			for (int i = 0; i < parm.size(); i++) {
				query.setParameter(i, parm.get(i));
			}
		}
			
		return query.list();
	}

	@Override
	public PageResult findObjectsList(QueryHelper queryHelper, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<Object> parm = queryHelper.getParameters();
		Query queryTotalCount = getSession().createQuery(queryHelper.getQueryCountHql());
		if(parm != null){
			for (int i = 0; i < parm.size(); i++) {
				queryTotalCount.setParameter(i, parm.get(i));
			}
		}
		Long totalCount = (Long) queryTotalCount.uniqueResult();
		
		
		Query query = getSession().createQuery(queryHelper.getQueryListHql());
		if(parm != null){
			for (int i = 0; i < parm.size(); i++) {
				query.setParameter(i, parm.get(i));
			}
		}
		if(pageNo < 1) pageNo = 1;
		if(pageNo> (totalCount+pageSize-1)/pageSize){
            pageNo = pageNo-1;
        }
		
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		List items = query.list();
		
		PageResult pageResult = new PageResult(totalCount, pageNo, pageSize, items);
		return pageResult;
	}
	
	

}

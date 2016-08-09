package org.wyk.nsfw.user.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.wyk.main.dao.Impl.BaseDaoImpl;
import org.wyk.main.util.StringUtil;
import org.wyk.nsfw.user.dao.UserDao;
import org.wyk.nsfw.user.entity.User;
/**
 * 
 * @author wyk
 * @time 2016年6月2日
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	@Override
	public User findByAccount(User user) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("FROM User WHERE account=? and password=?");
				// 注意：参数索引从0开始
		query.setParameter(0, user.getAccount());
		query.setParameter(1, user.getPassword());
		List<User> list = query.list();
		if(list.size()>0){
			System.out.println("--"+(User) query.list().get(0));
			return (User) query.list().get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<User> findByAccountAndId(String id, String account) {
		String hql = "FROM User WHERE account=?";
		if(StringUtil.isNotBlank(id)){
			hql = " AND id=?";
		}
		Query query = getSession().createQuery(hql);
		// 注意：参数索引从0开始
		query.setParameter(0, account);
		if(StringUtil.isNotBlank(id)){
			query.setParameter(1, id);
		}
		List<User> list = query.list();		
		return list;
	}
}

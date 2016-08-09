package org.wyk.nsfw.user.dao;


import java.util.List;

import org.wyk.main.dao.BaseDao;
import org.wyk.nsfw.user.entity.User;
/**
 * 
 * @author wyk
 * @time 2016年6月2日
 */
public interface UserDao extends BaseDao<User>{
	public User findByAccount(User User);

	public List<User> findByAccountAndId(String id, String account);
}

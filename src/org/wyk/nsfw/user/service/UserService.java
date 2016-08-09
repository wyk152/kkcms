package org.wyk.nsfw.user.service;


import java.io.File;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.wyk.main.exception.ServiceException;
import org.wyk.nsfw.user.entity.User;
/**
 * 
 * @author wyk
 * @time 2016年6月2日
 */
public interface UserService{
	
	/*保存*/
	public void save(User entity);
	public void update(User entity);
	/*单个查找*/
	public User findById(String id);
	
	public void deleteById(String id);
	public List<User> findObjects();

	public User findByAccount1(User User) throws ServiceException;
	public User findByAccount(User User) throws ServiceException;
	public List<User> findByAccountAndId(String id, String account);

	public void exportExcel(List<User> userList, ServletOutputStream outputStream);

	public void importExcel(File userExcel, String userExcelFileName);
	
	
}

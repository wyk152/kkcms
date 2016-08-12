package org.wyk.nsfw.user.service;


import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.wyk.main.exception.ServiceException;
import org.wyk.main.service.BaseService;
import org.wyk.nsfw.user.entity.User;
import org.wyk.nsfw.user.entity.UserRole;
/**
 * 
 * @author wyk
 * @time 2016年6月2日
 */
public interface UserService extends BaseService<User>{


	//导出用户列表
	public void exportExcel(List<User> userList, ServletOutputStream outputStream);
	//导入用户列表
	public void importExcel(File userExcel, String userExcelFileName);
	/**
	 * 根据帐号和用户id查询用户
	 * @param id 用户ID
	 * @param account 用户帐号
	 * @return 用户列表
	 */
	public List<User> findUserByAccountAndId(String id, String account);
	
	//保存用户及其对应的角色
	public void saveUserAndRole(User user, String... roleIds);
	//保存用户及其对应的角色
	public void updateUserAndRole(User user, String... roleIds);
	//根据用户id获取该用户对应的所有用户角色
	public List<UserRole> getUserRolesByUserId(String id);
	//根据用户的帐号和密码查询用户列表
	public List<User> findUserByAccountAndPass(String account, String password);

	
	
}

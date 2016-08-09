package org.wyk.main.permission.impl;

import java.util.List;

import javax.annotation.Resource;

import org.wyk.main.permission.PermissionCheck;
import org.wyk.nsfw.role.entity.Role;
import org.wyk.nsfw.role.entity.RolePrivilege;
import org.wyk.nsfw.user.entity.User;
import org.wyk.nsfw.user.entity.UserRole;
import org.wyk.nsfw.user.service.UserService;


public class PermissionCheckImpl implements PermissionCheck {
	
	@Resource
	private UserService userService;

	@Override
	public boolean isAccessible(User user, String code) {
		//1、获取用户的所有角色
		List<UserRole> list = user.getUserRoles();
		if(list == null){
			list = userService.getUserRolesByUserId(user.getId());
		}
		
		//2、根据每个角色对于的所有权限进行对比
		if(list != null && list.size()>0){
			for(UserRole ur: list){
				Role role = ur.getId().getRole();
				for(RolePrivilege rp: role.getRolePrivileges()){
					//对比是否有code对应的权限
					if(code.equals(rp.getId().getCode())){
						//说明有权限，返回true
						return true;
					}
				}
			}
		}
		return false;
	}

}

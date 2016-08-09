package org.wyk.nsfw.role.dao;

import org.wyk.main.dao.BaseDao;
import org.wyk.nsfw.role.entity.Role;

public interface RoleDao extends BaseDao<Role> {

	//删除该角色对于的所有权限
	public void deleteRolePrivilegeByRoleId(String roleId);

}

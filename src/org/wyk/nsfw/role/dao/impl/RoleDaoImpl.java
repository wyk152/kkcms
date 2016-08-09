package org.wyk.nsfw.role.dao.impl;

import org.hibernate.Query;
import org.wyk.main.dao.Impl.BaseDaoImpl;
import org.wyk.nsfw.role.dao.RoleDao;
import org.wyk.nsfw.role.entity.Role;


public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public void deleteRolePrivilegeByRoleId(String roleId) {
		Query query = getSession().createQuery("DELETE FROM RolePrivilege WHERE id.role.roleId=?");
		query.setParameter(0, roleId);
		query.executeUpdate();
	}

}

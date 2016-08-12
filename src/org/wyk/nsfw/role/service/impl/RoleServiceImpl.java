package org.wyk.nsfw.role.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wyk.main.service.impl.BaseServiceImpl;
import org.wyk.nsfw.role.dao.RoleDao;
import org.wyk.nsfw.role.entity.Role;
import org.wyk.nsfw.role.service.RoleService;


@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	
	//@Autowired
	private RoleDao roleDao;
	@Resource
	public void setRoleDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
		this.roleDao = roleDao;
	}
	


}

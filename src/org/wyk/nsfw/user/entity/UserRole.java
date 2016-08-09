package org.wyk.nsfw.user.entity;

import java.io.Serializable;

public class UserRole implements Serializable {

	/**角色实体
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserRoleId id;

	public UserRole() {
	}

	public UserRole(UserRoleId id) {
		this.id = id;
	}

	public UserRoleId getId() {
		return id;
	}

	public void setId(UserRoleId id) {
		this.id = id;
	}
	
	
}

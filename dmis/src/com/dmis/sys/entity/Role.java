package com.dmis.sys.entity;

/**
 * 角色表
 * @author Administrator
 *
 */
public class Role {

	private Long id;
	
	//
	private String roleName;
	
	//
	private String roleNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	
	
}

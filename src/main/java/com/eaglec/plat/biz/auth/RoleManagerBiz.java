package com.eaglec.plat.biz.auth;

import java.util.List;

import com.eaglec.plat.domain.auth.Role;

/**
 * @author cs
 *角色crud
 */
public interface RoleManagerBiz {
	//添加
	public Role saveRole(Role roles);
	//查询所有
	public List<Role> queryRole();
	//根据id
	public Role queryRoleByName(String rolename);
	//删除
	public void deleteRole(Role roles);
	

}

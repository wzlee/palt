package com.eaglec.plat.biz.auth;

import java.util.List;
import java.util.Map;

import com.eaglec.plat.domain.auth.User;


/**
 * @author cs
 *用户的CRUD
 */
public interface UserManagerBiz {
	//添加
	public User saveUser(User user);
	//查询
	public List<User> findUser();
	//根据用户名查询
	public User findUserByUsername(String username);
	//根据roleid 查询用户
	public List<User> findUserByRoleId(Integer roleid);
	//删除
	public void deleteUser(User user);
	

}

package com.eaglec.plat.biz.impl.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eaglec.plat.biz.auth.UserManagerBiz;
import com.eaglec.plat.dao.auth.UserDao;
import com.eaglec.plat.domain.auth.User;

@Service
public class UserManagerBizImpl implements UserManagerBiz {
	
	@Autowired
	private UserDao userDao;
	
	//添加
	public User saveUser(User user){
		return userDao.saveOrUpdate(user);
	}
	//查询
	public List<User> findUser(){
		return userDao.findList("from User");
	}
	//删除
	public void deleteUser(User user){
		userDao.delete(user);
	}
	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.get("from User u where u.username='"+username+"'");
	}
	@Override
	public List<User> findUserByRoleId(Integer roleid) {
		// TODO Auto-generated method stub
		return userDao.findList("from User u where u.role.id="+roleid);
	}
	

}

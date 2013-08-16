package com.eaglec.plat.dao.impl.auth;

import org.springframework.stereotype.Repository;

import com.eaglec.plat.dao.auth.UserDao;
import com.eaglec.plat.dao.impl.BaseDaoImpl;
import com.eaglec.plat.domain.auth.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}

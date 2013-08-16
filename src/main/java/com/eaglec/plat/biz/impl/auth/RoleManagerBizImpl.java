package com.eaglec.plat.biz.impl.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eaglec.plat.biz.auth.RoleManagerBiz;
import com.eaglec.plat.dao.auth.RoleDao;
import com.eaglec.plat.domain.auth.Role;

@Service
public class RoleManagerBizImpl implements RoleManagerBiz {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public Role saveRole(Role roles) {
		// TODO Auto-generated method stub
		return roleDao.save(roles);
	}

	@Override
	public List<Role> queryRole() {
		// TODO Auto-generated method stub
		return roleDao.findList("from Role");
	}

	@Override
	public void deleteRole(Role roles) {
		// TODO Auto-generated method stub
		roleDao.delete(roles);
	}

	@Override
	public Role queryRoleByName(String rolename) {
		// TODO Auto-generated method stub
		return roleDao.get("from Role u where u.rolename='"+rolename+"'");
	}
	
}
	



package com.eaglec.plat.biz.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eaglec.plat.biz.service.ServiceOrgBiz;
import com.eaglec.plat.dao.service.ServiceOrgDao;
import com.eaglec.plat.domain.service.ServiceOrg;

/**
 * 服务机构Service<br/>
 * 提供服务机构的业务操作
 * 
 * @author Xiadi
 * @since 2013-8-9
 * 
 */
@Service
public class ServiceOrgBizImpl implements ServiceOrgBiz {
	
	@Autowired
	private ServiceOrgDao serviceOrgDao;
	
	/* (non-Javadoc)
	 * @see com.eaglec.plat.service.impl.era#add(com.eaglec.plat.domain.ServiceOrg)
	 */
	@Override
	public ServiceOrg add(ServiceOrg serviceOrg){
		return serviceOrgDao.save(serviceOrg);
	}
	
	/*
	 * 查找所有的服务机构
	 * @author pangyf
	 * @since 2013-8-14
	 */
	@Override
	public List<ServiceOrg> findAll() {		
		String hql = "from ServiceOrg where 1=1 order by id";
		return serviceOrgDao.findList(hql);
		
	}
	
	
}
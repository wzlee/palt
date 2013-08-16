package com.eaglec.plat.biz.service;

import java.util.List;

import com.eaglec.plat.domain.service.ServiceOrg;

/**
 * 服务机构Service<br/>
 * 提供服务机构的业务操作
 * 
 * @author Xiadi
 * @since 2013-8-9
 * 
 */
public interface ServiceOrgBiz {

	/**
	 * 添加服务机构
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param serviceOrg
	 *@return
	 */
	public abstract ServiceOrg add(ServiceOrg serviceOrg);
	
	
	/**
	 * 查找所有的服务机构
	 *@author pangyf
	 *@since 2013-8-14 
	 */
	public List<ServiceOrg> findAll();

}
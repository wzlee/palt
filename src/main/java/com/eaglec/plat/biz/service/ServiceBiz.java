package com.eaglec.plat.biz.service;

import java.util.List;

import com.eaglec.plat.domain.service.Service;
import com.eaglec.plat.view.JSONData;
import com.eaglec.plat.view.JSONResult;

/**
 * 服务Service<br/>
 * 封装对服务的相关操作
 * 
 * @author Xiadi
 * @since 2013-8-9
 * 
 */
public interface ServiceBiz {

	/**
	 * 添加服务
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param service
	 *@return Service
	 */
	public abstract Service add(Service service);

	/**
	 * 保存服务(saveOrUpdate)
	 *@author lizhiwei
	 *@since 2013-8-15 
	 *
	 *@param service
	 *@return Service
	 */
	public abstract Service save(Service service);
	
	/**
	 * 保存服务(saveOrUpdate)
	 *@author lizhiwei
	 *@since 2013-8-15 
	 *
	 *@param service
	 *@return Service
	 */
	public abstract Service update(Service service);
	
	/**
	 * 根据id得到服务
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param id 服务id
	 *@return Service
	 */
	public abstract Service findServiceById(Integer id);

	/**
	 * 根据名称得到单个服务
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param serviceName
	 *@return Service
	 */
	public abstract Service findServiceByName(String serviceName);
	
	/**
	 * 查询某个状态下的所有服务
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param serviceName
	 *@return Service
	 */
	public abstract List<Service> queryServiceByStatus(String serviceStatus);

	/**
	 * 删除服务对象
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param service 服务对象
	 */
	public abstract void delete(Service service);
	
	
	/**
	 * 
	 * @author huyj
	 * @sicen 2013-8-12
	 * @description 根据服务状态查询服务，支持多状态查询 
	 * @param serviceStatus 服务状态 使用,分割 例：01,02,03
	 */
	public abstract  List<Service> findServiceListByStatus(String queryStatus,int start,int limit);
	
	/**
	 * 
	 * @author lizw
	 * @sicen 2013-8-12
	 * @description 根据服务状态查询服务，支持多状态查询 
	 * @param serviceStatus 服务状态 使用,分割 例：01,02,03
	 */
	public abstract JSONData<Service> findServiceListByQuerytatus(
			String queryStatus, String sname, int start, int limit);
	
	/**
	 * 
	 * @author huyj
	 * @sicen 2013-8-12
	 * @description 根据服务名称查询服务，支持模糊查询
	 * @param serviceStatus 服务名称 
	 */
	public abstract List<Service> findServiceListByName(String serviceName,int start,int limit);
	
	/**
	 * 
	 * @author huyj
	 * @sicen 2013-8-12
	 * @description 根据服务id查询服务
	 * @param id 服务名称  支持多id查询 每个id使用,分隔
	 */
	public abstract List<Service> findServiceListById(String id,int start,int limit);
	
	/**
	 * 
	 * @author huyj
	 * @sicen 2013-8-12
	 * @description 查找所有服务
	 * @return 所有服务
	 */
	public List<Service> findAll();
	
	/**
	 * 
	 * @author lizhiwei
	 * @sicen 2013-8-15
	 * @description 添加服务
	 * @param service 服务对象
	 */
	public void saveService(Service service);
	
	/**
	 * 
	 * @author huyj
	 * @sicen 2013-8-12
	 * @description 修改服务信息及状态
	 * @param service 服务对象
	 */
	public void updateService(Service service);
	
	/**
	 * 根据服务状态和服务名字分页查询
	 * @author xuwf
	 * @since 2013-8-15
	 * 
	 * @param serviceStatus 服务状态
	 * @param servicename 服务名称  支持模糊查询
	 * @param start 起始
	 * @param limit 限制
	 * @return JSONData<Service> service列表 JSON格式
	 */
	public abstract JSONData<Service> queryStatistics(String currentStatus,String servicename,int start,int limit);
	
	/**
	 * 审核服务
	 * @author liuliping
	 * @since  2013-8-12
	 * 
	 * @param  id	服务对象主键
	 * @param access	服务审核通过:0,未通过:1
	 * @return	JSONResult	审核结果返回信息
	 */
	public abstract JSONResult audit(Integer id, int access);	
	
}
package com.eaglec.plat.biz.impl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.eaglec.plat.biz.service.ServiceBiz;
import com.eaglec.plat.dao.service.ServiceDao;
import com.eaglec.plat.domain.service.Service;
import com.eaglec.plat.utils.Constant;
import com.eaglec.plat.view.JSONData;
import com.eaglec.plat.view.JSONResult;

@org.springframework.stereotype.Service
public class ServiceBizImpl implements ServiceBiz {
	 
	@Autowired
	private ServiceDao serviceDao;
	
	/* (non-Javadoc)
	 * @see com.eaglec.plat.service.impl.ServiceService#add(com.eaglec.plat.domain.Service)
	 */
	@Override
	public Service add(Service service){
		return serviceDao.save(service);
	}
	
	/* (non-Javadoc)
	 * @see com.eaglec.plat.service.impl.ServiceService#findServiceById(java.lang.Integer)
	 */
	@Override
	public Service findServiceById(Integer id){
		return serviceDao.get(id);
	}
	
	/* (non-Javadoc)
	 * @see com.eaglec.plat.service.impl.ServiceService#findServiceByName(java.lang.String)
	 */
	@Override
	public Service findServiceByName(String serviceName){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", serviceName);
		return serviceDao.get("from Service where serviceName=:name", map);
	}
	
	/* (non-Javadoc)
	 * @see com.eaglec.plat.service.impl.ServiceService#delete(com.eaglec.plat.domain.Service)
	 */
	@Override
	public void delete(Service service){
		serviceDao.delete(service);
	}

	@Override
	public List<Service> queryServiceByStatus(String serviceStatus) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", serviceStatus);
		return serviceDao.findList("from Service where currentStatus=:status", map);
	}

	@Override
	public JSONData<Service> queryStatistics(String currentStatus,String servicename, int start,
			int limit) { 
		String hql = "from Service s where 1=1";
		if(!"".trim().equals(currentStatus) && null != currentStatus){
			hql += " and s.currentStatus ='" + currentStatus+ "'";
		}
		if(!"".trim().equals(servicename) && null != servicename){
			hql += " and s.serviceName like '%"+ servicename + "%'";
		}
		return serviceDao.outJSONData(hql, start, limit);
	}
	
	@Override
	public List<Service> findServiceListByStatus(String queryStatus,
			int start,int limit) {
		// begin 2013-8-12 by huyj
		String hql = "from Service where currentStatus in (" + queryStatus+ ")";
		return serviceDao.findList(hql, start, limit);
		// end 2013-8-12 by huyj
	}
	

	@Override
	public List<Service> findServiceListByName(String serviceName, int limit,
			int start) {
		// begin 2013-8-12 by huyj
		String hql = "from Service where serviceName like " + serviceName;
		return serviceDao.findList(hql, start, limit);
		// end 2013-8-12 by huyj
	}

	@Override
	public List<Service> findAll() {
		// begin 2013-8-12 by huyj
		String hql = "from Service where 1=1 order by id";
		return serviceDao.findList(hql);
		// end 2013-8-12 by huyj
	}

	@Override
	public List<Service> findServiceListById(String id, int start,int limit) {
		// begin 2013-8-12 by huyj
		String hql = "from Service where id in (" + id + ")";
		return serviceDao.findList(hql, start, limit);
		// end 2013-8-12 by huyj
	}

	@Override
	public void saveService(Service service) {
		serviceDao.save(service);
	}
	
	@Override
	public void updateService(Service service) {
		// begin 2013-8-12 by huyj
		serviceDao.update(service);
		// end 2013-8-12 by huyj
	}

	/**
	 * lizhiwei
	 */
	@Override
	public JSONData<Service> findServiceListByQuerytatus(String queryStatus,
			String sname, int start, int limit) {
		String hql = "from Service where currentStatus in('" + queryStatus+ "')";
		if (StringUtils.contains(queryStatus, Constant.SERVICE_STATUS_DOWN)
				&& StringUtils.contains(queryStatus,
						Constant.SERVICE_STATUS_ADDED_AUDIT)) {
			hql += " and lastStatus = '" + Constant.SERVICE_STATUS_DOWN + "'";
		}
		if (StringUtils.isNotEmpty(sname))
		{
			hql += " and serviceName like '%" + sname + "%'";
		}
		return serviceDao.outJSONData(hql,start, limit);
	}

	@Override
	public Service save(Service service) {
		// TODO Auto-generated method stub
		return serviceDao.saveOrUpdate(service);
	}

	@Override  
	public JSONResult audit(Integer id, int access) {
		JSONResult jr = new JSONResult(false, null);
		String cs = null;	//服务当前状态
		String ls = null;		//服务上一个状态
		try {
			Service entity = serviceDao.get(id);
			cs = entity.getCurrentStatus();	
			ls = entity.getLastStatus();		
			
			if (access == 0) {	//通过审核,更改为下一个服务状态
				switch (cs) {
				case Constant.SERVICE_STATUS_ADDED_AUDIT:	//上架审核中
					entity.setCurrentStatus(Constant.SERVICE_STATUS_ADDED);	//已上架
					break;
				case Constant.SERVICE_STATUS_CHANGE_AUDIT:	//变更审核中
					entity.setCurrentStatus(ls);
					break;
				case Constant.SERVICE_STATUS_DOWN_AUDIT:	//下架审核中
					entity.setCurrentStatus(Constant.SERVICE_STATUS_DOWN);	//已下架
					break;
				default:
					break;
				}
			} else {	//未通过审核
				entity.setCurrentStatus(ls);	//恢复上一个状态
			}
			serviceDao.update(entity);
			jr.setSuccess(true);
			jr.setMessage("更新服务状态成功");
			return jr;
		} catch (Exception e) {
			jr.setMessage("更新服务状态失败!");
			return jr;
		}
	}
}
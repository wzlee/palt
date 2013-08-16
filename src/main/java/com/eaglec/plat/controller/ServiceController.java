package com.eaglec.plat.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.eaglec.plat.biz.service.ServiceBiz;
import com.eaglec.plat.domain.service.Service;
import com.eaglec.plat.utils.Constant;
import com.eaglec.plat.view.JSONData;
import com.eaglec.plat.view.JSONResult;

@Controller
@RequestMapping(value = "/service")
public class ServiceController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	private ServiceBiz serviceBiz;
	
	/**
	 * 添加服务
	 *@author pangyf
	 *@since 2013-8-14 
	 *
	 *@param service
	 *@return 
	 */
	@RequestMapping(value = "/save")
	public void add(@RequestParam("service")Service service,HttpServletRequest request,HttpServletResponse response) {
		try {
			if(service.getId() == null){
				service.setServiceNo(Long.toString(new Date().getTime()));
				serviceBiz.saveService(service);
				this.outJson(response,new JSONResult(true,"服务添加成功!"));
				logger.info("[ "+service.getServiceName()+" ]添加成功!");
			}else{
				serviceBiz.updateService(service);
				this.outJson(response,new JSONResult(true,"服务修改成功!"));
				logger.info("[ "+service.getServiceName()+" ]修改成功!");
			}
		} catch (Exception e) {
			this.outJson(response,new JSONResult(false,"服务保存失败!异常信息:"+e.getLocalizedMessage()));
			logger.info("服务保存失败!异常信息:"+e.getLocalizedMessage());
		}
	}
	

	/**
	 * 审核服务
	 *@author liuliping
	 *@since 2013-08-15 
	 *
	 *@param id 服务主键
	 *@return access 服务审核:0通过,1未通过	 
	 */
	@RequestMapping(value = "/audit")
	public void audit(Integer id, Integer access, 
			HttpServletRequest request,HttpServletResponse response) {
//		try {
//			serviceBiz.save(service);
//			this.outJson(response,new JSONResult(true,"服务保存成功!"));
//			logger.info("[ "+service.getServiceName()+" ]保存成功!");
//		} catch (Exception e) {
//			this.outJson(response,new JSONResult(false,"服务保存失败!异常信息:"+e.getLocalizedMessage()));
//			logger.info("服务保存失败!异常信息:"+e.getLocalizedMessage());
//		}
		JSONResult jr = serviceBiz.audit(id, access);
		outJson(response, jr);
	}

	/**
	 * 添加服务
	 *@author pangyf
	 *@since 2013-8-14 
	 *
	 *@param service
	 *@return 
	 */
	@RequestMapping(value = "/update")
	public void update(@RequestParam("service")Service service,HttpServletRequest request,HttpServletResponse response) {
		logger.info("queryString:"+request.getQueryString());
		try {
			serviceBiz.save(service);
			logger.info("[ "+service.getServiceName()+" ]保存成功!");
			this.outJson(response,new JSONResult(true,"服务保存成功!"));
		} catch (Exception e) {
			this.outJson(response,new JSONResult(false,"服务保存失败!异常信息:"+e.getLocalizedMessage()));
			logger.info("服务保存失败!异常信息:"+e.getLocalizedMessage());
		}
	}

	/**
	 * 
	 * @author huyj
	 * @sicen 2013-8-14
	 * @description 更新服务内容
	 * @param service
	 *            服务对象
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/updateComments")
	public void updateComments(Service service, HttpServletRequest request,
			HttpServletResponse response) {
		Service oldService = serviceBiz.findServiceById(service.getId());
		String current = oldService.getCurrentStatus();
		service.setLastStatus(current);
		service.setCurrentStatus(Constant.SERVICE_STATUS_CHANGE_AUDIT);
		try {
			serviceBiz.updateService(service);
			logger.info("[ " + service.getServiceName() + " ]申请变更成功!");
			this.outJson(response, new JSONResult(true, "服务申请变更成功!"));
		} catch (Exception e) {
			this.outJson(
					response,
					new JSONResult(false, "服务申请变更失败!异常信息:"
							+ e.getLocalizedMessage()));
		}
	}

	/**
	 * 查询服务，按状态查询
	 * 
	 * @author lizhiwei
	 * @since 2013-8-15
	 * 
	 * @param service
	 * @return
	 */
	@RequestMapping(value = "/query")
	public void query(
			@RequestParam("queryStatus")String queryStatus,
			@RequestParam("serviceName") String sname,
			@RequestParam(value="start",defaultValue="0",required=false)int start,
			@RequestParam(value="limit",defaultValue="25",required=false)int limit,
			HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("queryParams[ queryStatus:"+queryStatus+" ]");
		this.outJson(response, serviceBiz.findServiceListByQuerytatus(
				queryStatus, sname, start, limit));
	}
	
	/**
	 * 删除服务
	 *@author lizhiwei
	 *@since 2013-8-15 
	 *
	 *@param service
	 *@return 
	 */
	@RequestMapping(value = "/delete")
	public void delete(@RequestParam("services")String services,HttpServletRequest request,HttpServletResponse response) {
		logger.info("queryString:"+request.getQueryString());
		List<Service> list = JSON.parseArray(services, Service.class);
		try {
			for(Service service:list){
				serviceBiz.delete(service);
				logger.info("[ "+service.getServiceName()+" ]删除成功!");
			}
			this.outJson(response,new JSONResult(true,"服务删除成功!"));
		} catch (Exception e) {
			this.outJson(response,new JSONResult(false,"服务删除失败!异常信息:"+e.getLocalizedMessage()));
			logger.info("服务删除失败!异常信息:"+e.getLocalizedMessage());
		}
	}
	
	/**
	 * * 查询服务，按状态查询
	 * 
	 * @author xuwf
	 * @since 2013-8-5
	 * 
	 * @param status	服务状态
	 * @param currentPage	当前页
	 * @param start			起始值
	 * @param limit			每页条数
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/find")
	public void find(@RequestParam(value="status",required=false)String status,
			@RequestParam(value="sname",required=false)String sname,
			@RequestParam("page")Integer page,
			@RequestParam("start")Integer start,
			@RequestParam("limit")Integer limit,
			HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("queryParams[ status:"+status+",sname,"+sname+"currentPage:"+page+",start:"+start+",limit:"+limit+"]");
		if(null == status || "所有服务".equals(status)){
			status = "";
		}
		JSONData<Service> services = serviceBiz.queryStatistics(status, sname,start, limit);
		this.outJson(response,services);
	}
}

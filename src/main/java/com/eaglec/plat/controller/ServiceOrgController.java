package com.eaglec.plat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import com.eaglec.plat.biz.service.ServiceOrgBiz;

import com.eaglec.plat.domain.service.ServiceOrg;


@Controller
@RequestMapping(value = "/serviceorg")
public class ServiceOrgController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	private ServiceOrgBiz serviceOrgBiz;
	
	/**
	 * 添加服务机构
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param service
	 *@return 
	 */
	@RequestMapping(value = "/add")
	public String add(ServiceOrg serviceOrg) {
		//逻辑处理 略
		//添加
		serviceOrgBiz.add(serviceOrg);
		return "yes";
	}	
	
	/**
	 * 加载所有的服务机构
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param service
	 *@return 
	 */
	@RequestMapping(value="/load")
	public void findServiceOrg(HttpServletRequest request,HttpServletResponse response){
		
		this.outJson(response, serviceOrgBiz.findAll());
		
	}
}

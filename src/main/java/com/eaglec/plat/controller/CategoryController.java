package com.eaglec.plat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eaglec.plat.biz.publik.CategoryBiz;
import com.eaglec.plat.repositories.CategoryRepository;

@Controller
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryBiz categoryBiz;
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public void queryCategory(@RequestParam(defaultValue="all",required=false,value="clazz")String clazz,@RequestParam(defaultValue="0",required=false,value="pid")int pid,HttpServletRequest request,HttpServletResponse response) {
		logger.info(request.getParameterMap().toString());
		this.outJson(response, categoryBiz.findCategoryByClazzAndPid(clazz,pid));
	}
	
	/**
	 * 加载所有类别
	 * @author xuwf
	 * @since 2013-8-12
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/findAll")
	public void findCategory(HttpServletRequest request,HttpServletResponse response){
		this.outJson(response, categoryBiz.findAll());
	}
}

package com.eaglec.plat.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eaglec.plat.repositories.IpDataRepository;
import com.eaglec.plat.view.JSONData;

@Controller
@RequestMapping(value = "/ipdata")
public class IpdataController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(IpdataController.class);
	
	@Autowired
	GridFsOperations operations;
	@Autowired
	private IpDataRepository ipDataRepository;
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public void loadAll(@RequestParam(defaultValue="0",required=false,value="start")int start,@RequestParam(defaultValue="10",required=false,value="limit")int limit,HttpServletRequest request,HttpServletResponse response) {
		logger.info("requestparams:start："+start+",limit："+limit);
		this.outJson(response, new JSONData(true,ipDataRepository.findAll(), (int)ipDataRepository.count()));
	}
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public String loadAll(@PathVariable String id,Model model) throws IOException {
		logger.info("find ipdata by id:"+id);
		model.addAttribute("ipdata",ipDataRepository.findOne(id));
		return "ipdata";
	}
}

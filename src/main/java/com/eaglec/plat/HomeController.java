package com.eaglec.plat;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * 二级域名跳转
	 * 需更改本地host文件(路径:C:\Windows\System32\drivers\etc)：
	 * 127.0.0.1	www.localhost
	 * 127.0.0.1	hj.localhost
	 * 127.0.0.1	sz.localhost
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request,HttpServletResponse response,Locale locale, Model model) {
		logger.info("Welcome index! The client locale is:"+locale+",ip is:"+request.getRemoteAddr()+",userAgent is:"+request.getHeader("user-agent"));
		String serverName = request.getServerName();
		int index = serverName.indexOf("localhost");
		if(index <= 0){
			return "home";
		}else if(index >0 && index <=2){
			return "error/404";
		}else{
			String sld = serverName.substring(0, index-1);
			if(sld.equals("www")){
				return "home";
			}else{
				return sld+"/index";
			}
		}
	}
	
	/**
	 * 组件测试:eg：http://localhost/test/upload
	 * @param component
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/test/{page}", method = RequestMethod.GET)
	public String uploadCode(@PathVariable String page,HttpServletRequest request,HttpServletResponse response,Model model) {
		return page;
	}
	
}

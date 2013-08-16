package com.eaglec.plat.utils;

import java.util.Random;
import java.util.ResourceBundle;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Common {
	public static String superAdmin;	//超级管理员名称
	public static String accinitpassword;	//超级管理员名称
	public static int targetW;	//服务缩略图宽度
	public static int targetH;	//服务缩略图高度
//	public static String enterpriseLogo;	//企业logo上传的路径
//	public static String imagesPath;	//服务缩略图上传路径
//	public static String contentImagesPath;	//服务描述内容中的图片上传路径
//	public static String moduleIcon;	//色块图标或图片
	public static String serveDefaultimg;	//服务默认缩略图
	public static String oaDomainPath;		//OA访问的域路径
	public static String uploadPath;
	public static String defaultDomain;
	
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("config");
//		superAdmin = bundle.getString("superAdmin");
//		accinitpassword = bundle.getString("accountInitializePassword");
//		enterpriseLogo = bundle.getString("enterprise.logo");
//		imagesPath = bundle.getString("serve.imagesPath");
//		contentImagesPath = bundle.getString("serve.contentImagesPath");
//		moduleIcon = bundle.getString("module.moduleIcon");
//		targetW = Integer.parseInt(bundle.getString("serve.targetW"));
//		targetH = Integer.parseInt(bundle.getString("serve.targetH"));
//		serveDefaultimg = bundle.getString("serve.defaultImg");
//		oaDomainPath = bundle.getString("oaDomainPath");
		uploadPath = bundle.getString("uploadPath");
//		defaultDomain=bundle.getString("defaultDomain");
	}

	/**
	 * @date：2013-3-19
	 * @author：lwch
	 * @description：设置cookie内容
	 */
	public static void setCookies(HttpServletResponse response, String cookieName, String cookieValue, int limitTime, String path){
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(limitTime);	//cookie保存一个季度(90天)
		cookie.setPath(path);
		response.addCookie(cookie);
	}
	
	/**
	 * @date：2013-3-19
	 * @author：lwch
	 * @description：删除cookiesName[]中的cookies
	 */
	public static void removeCookies(HttpServletRequest request, HttpServletResponse response, String cookiesName[]){
		Cookie[] cookies = request.getCookies();  
        if (cookies != null) {
            for (Cookie cookie : cookies) {
            	for (int i = 0; i < cookiesName.length; i++) {
					if (cookiesName[i].equals(cookie.getName())) {  
						cookie.setValue("");
						cookie.setMaxAge(0); 
						cookie.setPath("/");
						response.addCookie(cookie); 
					}  
				}
            }  
        }
	}
	
	
	
	// 随机产生一个10位的随机数
	public static String getPictureFileName() {
		String s = "";
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int n = random.nextInt(36);
			if (n >= 0 && n <= 9) {
				s += String.valueOf(n);
			}else{
				n = n-10;
				s += (char)(97+n);
			}
		}
		return s;

	}
}




package com.eaglec.plat.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eaglec.plat.biz.auth.RightsManagerBiz;
import com.eaglec.plat.biz.auth.RoleManagerBiz;
import com.eaglec.plat.biz.auth.UserManagerBiz;
import com.eaglec.plat.domain.auth.Rights;
import com.eaglec.plat.domain.auth.Role;
import com.eaglec.plat.domain.auth.User;
import com.eaglec.plat.view.JSONData;
/**
 * 权限信息
 * @author chens
 */
@Controller
@RequestMapping(value = "/rights")
public class ManagerRightsController extends BaseController {

	@Resource
	private RightsManagerBiz authManagerService;
	@Autowired
	private RoleManagerBiz roleManagerBiz;
	@Autowired
	private UserManagerBiz userManagerBiz;
	
	//查询权限
		@RequestMapping(value = "/load", method = RequestMethod.GET)
		@ResponseBody
		public void userAuthQuery(@RequestParam Integer pid,HttpServletRequest request,HttpServletResponse response){
			User user =(User) request.getSession().getAttribute("user");
			if(user!=null&&user.getRole()!=null){
				List<Rights> list = user.getRole().getRights();
				List<Rights> list1 = new ArrayList<Rights>();
				if(list!=null&&list.size()!=0){
					for(int i = 0 ;i<list.size();i++){
						if(list.get(i).getPid().equals(pid)){
							list1.add(list.get(i));
						}
					}
				}
				
				
			this.outJson(response, list1);
			}
		}
		//查询角色
		@RequestMapping(value = "/queryrole", method = RequestMethod.GET)
		@ResponseBody
		public void queryrole(HttpServletRequest request,HttpServletResponse response){
			List<Role> list =roleManagerBiz.queryRole();
				this.outJson(response, new JSONData(true, list, list.size()));
		}
		//根据roleid查询用户
		@RequestMapping(value = "/queryusers", method = RequestMethod.GET)
		@ResponseBody
		public void queryusers(HttpServletRequest request,HttpServletResponse response,Integer roleid){
			List<User> list=new ArrayList<User>();
			if(roleid!=null&&!roleid.equals("")){
				 list=userManagerBiz.findUserByRoleId(roleid);
			}else{
				list=userManagerBiz.findUser();
			}
			this.outJson(response, new JSONData(true, list, list.size()));
		}
	
	//删除权限
	@RequestMapping(value = "/userAuthDel")
	public void userAuthDel(final ModelMap model,
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String, String> params){
	
	}
	 
	//修改
	@RequestMapping(value = "/userAuthInput")
	public String userAuthInput(final ModelMap model,
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String, String> params){
		return null;
	}
	
	//新增
	@RequestMapping(value = "/userAuthSave")
	public String userAuthSave(final ModelMap model,
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String, String> params) throws SQLException{
	
		return "/auth/userAuthInput";
	}
	
}

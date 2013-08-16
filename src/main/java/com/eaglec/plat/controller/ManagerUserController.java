package com.eaglec.plat.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eaglec.plat.biz.auth.RoleManagerBiz;
import com.eaglec.plat.biz.auth.UserManagerBiz;
import com.eaglec.plat.domain.auth.Role;
import com.eaglec.plat.domain.auth.User;
import com.eaglec.plat.utils.MD5;
import com.eaglec.plat.view.JSONResult;
/**
 * 用户管理
 * @author chens
 */
@Controller
@RequestMapping(value = "/user")
public class ManagerUserController extends BaseController {

	@Autowired
	private UserManagerBiz userManagerBiz;
	@Autowired
	private RoleManagerBiz roleManagerBiz;
	
	//update用户所属角色
	@RequestMapping(value = "/update")
	@ResponseBody
	public void userupdate(
			String rolename,String username,HttpServletRequest request,HttpServletResponse response){
		try {
			Role role=null;
			User user = userManagerBiz.findUserByUsername(username);
			if(rolename!=null&&!rolename.equals("")){
				role = roleManagerBiz.queryRoleByName(rolename);
			}
			user.setRole(role);
			userManagerBiz.saveUser(user);
			this.outJson(response, new JSONResult(true, "修改成功"));
		} catch (Exception e) {
			this.outJson(response, new JSONResult(false, "修改失败"));
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//删除
	@RequestMapping(value = "/delete")
	@ResponseBody
	public void userdelete(
			String username,HttpServletRequest request,HttpServletResponse response){
		try {
			User user = userManagerBiz.findUserByUsername(username);
			userManagerBiz.deleteUser(user);
			this.outJson(response, new JSONResult(true, "删除成功"));
		} catch (Exception e) {
			this.outJson(response, new JSONResult(false, "删除失败"));
			e.printStackTrace();
		}
	}
	 
	
	
	//新增
	@RequestMapping(value = "/save")
	@ResponseBody
	public void usersave(
			String password1,String password,String username,String rolename,HttpServletRequest request,HttpServletResponse response){
		try {
			Role role=null;
			if(password==null||"".equals(password)){
				this.outJson(response, new JSONResult(false, "密码不能为空"));
				return;
			}else if(password1==null||"".equals(password1)){
				this.outJson(response, new JSONResult(false, "请填写密码验证"));
				return;
			}else if(!password.equals(password1)){
				this.outJson(response, new JSONResult(false, "两次密码不一致"));
				return;
			}else{
				if(username!=null&&!"".equals(username)){
					User user = userManagerBiz.findUserByUsername(username);
					if(user!=null){
						this.outJson(response, new JSONResult(false, "改用户名已经被注册 请从新申请"));
						return;
					}else{
						User user1 = new User();
						user1.setUsername(username);
						user1.setPassword(MD5.toMD5(password));
						if(rolename!=null&&!rolename.equals("")){
							role = roleManagerBiz.queryRoleByName(rolename);
							user1.setRole(role);
						}else{
							user1.setRole(null);
						}
						userManagerBiz.saveUser(user1);
						this.outJson(response, new JSONResult(true, "恭喜你注册成功"));
						return;
					}
				}
			}
		} catch (Exception e) {
			this.outJson(response, new JSONResult(false, "悲剧，注册失败"));
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

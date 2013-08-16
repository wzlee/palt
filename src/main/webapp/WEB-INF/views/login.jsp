<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div id="right">
   SESSION:${user }
			<form action="/login" method="post">
				<div id="top">用户登陆</div>
				
					用户名：<input id="username" style="width:140px" name="username" value=""/>
					密码：<input type="password"  style="width:140px" id="password" name="password" value=""/>
						<input type="submit" value="登录"/>
				
					<%-- <%
						String msg = "";
						String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
						if(error != null){
							if(error.endsWith("UnknownAccountException")){
								msg = "用户状态异常或用户名不存在";
							}
							if(error.endsWith("IncorrectCredentialsException")){
								msg = "用户名或密码错";
							}
						}
					%>
					<%=msg %> --%>
			</form>
		</div>
  </body>
</html>

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
   <div><shiro:hasPermission name="A"><a href="">日志记录A</a></shiro:hasPermission></div>
   <div><shiro:hasPermission name="A1"><a href="">日志记录A1</a></shiro:hasPermission></div>
   <div><shiro:hasPermission name="A2"><a href="">日志记录A2</a></shiro:hasPermission></div>
   <div><shiro:hasPermission name="A3"><a href="">日志记录A3</a></shiro:hasPermission></div>
   <div><shiro:hasPermission name="B"><a href="">日志记录B</a></shiro:hasPermission></div>
   <div><shiro:hasPermission name="B1"><a href="">日志记录B1</a></shiro:hasPermission></div>
   <div><shiro:hasPermission name="B2"><a href="">日志记录B2</a></shiro:hasPermission></div>
   <div><shiro:hasPermission name="B3"><a href="">日志记录B3</a></shiro:hasPermission></div>

  </body>
</html>

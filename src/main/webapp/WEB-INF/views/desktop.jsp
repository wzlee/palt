<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basePath%>">
	<title>Home</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="resources/css/desktop.css" />
    <link rel="stylesheet" type="text/css" href="jsLib/extjs/resources/css/ext-icon.css" />
    <!-- GC -->

    <!-- <x-compile> -->
    <!-- <x-bootstrap> -->
    <script type="text/javascript" src="jsLib/extjs/shared/include-ext.js"></script>
    <script type="text/javascript" src="jsLib/extjs/shared/options-toolbar.js"></script>
    <script type="text/javascript" src="jsLib/extjs/locale/ext-lang-zh_CN.js"></script>
    <!-- </x-bootstrap> -->
    <script type="text/javascript" src="app/test.js"></script>
</head>
<body>

</body>
</html>

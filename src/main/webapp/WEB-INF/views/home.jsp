<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>中小企业公共服务平台--运营支撑系统</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="resources/css/desktop.css" />
	<link rel="stylesheet" type="text/css" href="jsLib/extjs/resources/css/ext-patch.css"/>
	<link rel="stylesheet" type="text/css" href="jsLib/extjs/shared/example.css"/>
    <link rel="stylesheet" type="text/css" href="jsLib/extjs/resources/css/ext-icon.css" />
</head>
<body>
    <div id="loading-mask" style=""></div>
   	<div id="loading">
       <div class="loading-indicator">
           <img src="jsLib/extjs/resources/themes/images/cloud-loading.gif" width="45" height="30" style="margin:4px 4px;float:left;vertical-align:top;"/>
           <a href="./" target="_blank">欢迎登陆运营支撑系统</a>
           <br>
           <span id="loading-msg">加载样式资源中...</span>
       </div>
    </div>
    <script type="text/javascript">document.getElementById('loading-msg').innerHTML = '加载JS资源中...';</script>
    <script type="text/javascript" src="jsLib/extjs/shared/include-ext.js"></script>
    <script type="text/javascript" src="jsLib/extjs/shared/options-toolbar.js"></script>
    <script type="text/javascript" src="jsLib/extjs/shared/examples.js"></script>
    <script type="text/javascript" src="jsLib/extjs/locale/ext-lang-zh_CN.js"></script>
    <script type="text/javascript">document.getElementById('loading-msg').innerHTML = '系统初始化中...';</script>
	<script type="text/javascript" src="app/app.js"></script>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh">
	<head>
	    <base href="<%=basePath%>">
		<title>Home</title>
		<meta charset="UTF-8">
	</head>
<body>
	上传者:<input type="text" name="uploader" value="${upload.user.username }"><br>
	文件:<a href="upload/files/${upload.fileName }" >${upload.fileName }</a><br>
	图片:<img src="upload/images/${upload.imageName }" width="600" height="400">
</body>
</html>

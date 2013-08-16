<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>
	<form action="public/upload" method="post" ENCTYPE="multipart/form-data">
		上传者:<input type="text" name="uploader"><br>
		文件:<input type="file" name="file"><br>
		图片:<input type="file" name="image">
		<input type="submit" name="submit" value="提交">
	</form>
</body>
</html>

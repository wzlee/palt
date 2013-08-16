<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%response.setStatus(200);%>

<!DOCTYPE html>
<html>
<head>
	<title>404 - 页面不存在</title>
	<style type="text/css">
		a{
			text-decoration: none;
		}
	</style>
</head>

<body>
	<center>
	  <h1>404页面</h1>
	  <p>坑爹啊,你访问的资源又找不到了!</p>
	  <p><a href="<c:url value="/"/>">返回首页</a></p>
	</center>
</body>
</html>
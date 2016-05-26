<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Page</title>
<%@include file="/common/include.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctx}/static/js/custom/module/header/header.css"/>
</head>
<body>
	<script type="text/javascript" src="${ctx}/static/js/custom/module/header/header.js"></script>
	<c:if test="${loginUser ne null}">
		<h2>hello, <em>${loginUser.userName}</em></h2>
		<form:form action="${ctx}/logout" method="post">
			<input type="submit" value="注销"/>
		</form:form>
	</c:if>
	
	<c:if test="${loginUser eq null}">
		<form:form action="${ctx}/login" method="get">
			<input type="submit" value="登陆"/>
		</form:form>
	</c:if>
</body>
</html>
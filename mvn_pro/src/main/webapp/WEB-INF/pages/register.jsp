<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Page</title>
<%@include file="/common/include.jsp" %>
<script type="text/javascript" src="${ctx}/static/js/custom/module/register/register.js"></script>
</head>
<body>
	<div>
		<form:form action="${ctx}/register" method="post">
			<table>
				<tbody>
					<tr>
						<td>用户名：</td>
						<td>
							<input id="userName" name="userName" type="text"/>
						</td>
					</tr>
					<tr>
						<td>密码：</td>
						<td>
							<input id="password" name="password" type="password"/>
						</td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td>
							<input id="passwordConfirm" name="passwordConfirm" type="password"/>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="注册" title="click to register."/>
						</td>
						<!-- <td></td> -->
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
</body>
</html>
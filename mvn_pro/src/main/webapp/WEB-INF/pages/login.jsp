<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<%@include file="/common/include.jsp" %>
</head>
<body>
	<form:form action="${ctx}/login" method="post">
		<table>
			<tbody>
				<tr>
					<td>用户名：</td>
					<td>
						<input id="userName" name="userName" value="root" type="text"/>
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td>
						<input id="password" name="password" value="123456" type="password"/>
					</td>
				</tr>
				<tr>
					<td>验证码：</td>
					<td>
						<input id="kaptchaCode" name="kaptchaCode" type="text"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<img src="${ctx}/kaptcha" id="kaptchaImage"  style="margin-bottom: -3px"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input id="remember-me" name="remember-me" type="checkbox" checked="checked" value="true"/>
						<label><font style="font-size: x-small;">记住我</font></label>
					</td>
				</tr>
				<tr>
					<td>
						<input id="submitBtn" name="submitBtn" value="登录" type="submit"/>
					</td>
					<td>
						<a href="${ctx}/register">注册</a>
					</td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>
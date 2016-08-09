<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/common/header.jsp" %>
</head>
<body>
<br/><br/><br/><br/><br/><br/><br/>
<%-- <% pageContext.setAttribute("basePath", request.getContextPath()); %> --%>

	<form action="${basePath}/nsfw/user_login.action" method="post">
		<table align="center" border="1" cellpadding="5" cellspacing="0" >
			<tr align="left">
				<td>用户名:<input type="text" name="user.account" value="admin" /> </td>
			</tr>
			<tr align="left">
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;:<input type="password" name="user.password" value="123456" /> </td>
			</tr>
			<tr align="center">
				<td><input type="submit"  value="登录" /> </td>
			</tr>
		</table>
	</form>
</body>
</html>
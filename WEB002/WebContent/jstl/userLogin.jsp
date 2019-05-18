<%@page import="domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = new User();
		user.setUid(100);
		user.setUname("Tom");
		user.setPassword("123456");
		session.setAttribute("user", user);
	
	%>
</body>
</html>
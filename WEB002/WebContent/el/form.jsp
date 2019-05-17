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
		request.getParameter("username");
	
	%>
	
	${param.username }
	<hr/>
	${header["User-Agent"] }
	<hr/>
	${initParam.aaa }
	<hr/>
	${cookie.name.value }
	<hr/>
	${pageContext.request.contextPath }
	<hr/>
	
	
</body>
</html>
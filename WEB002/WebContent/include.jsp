<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is the include1.jsp!</h1>
	
	<%@ include file="/include2.jsp" %>
	<jsp:include page="/include2.jsp"></jsp:include>
	
</body>
</html>
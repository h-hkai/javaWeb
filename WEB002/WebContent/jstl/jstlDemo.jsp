
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${1 == 1 }">
		xxxx
	</c:if>
	
	<c:if test="${1 != 2 }">
		yyyy
	</c:if>
	
	<%
		request.setAttribute("count", 10);
	%>
	
	<c:if test="${count == 10 }">
		zzzz
	</c:if>
	
	<c:forEach begin="0" end="5" var="i">
		${i }<br/>
	</c:forEach>
	
	<c:forEach items="${productList }" var="pro">
		${pro.pname }
	</c:forEach>
	

	
	
	
</body>
</html>
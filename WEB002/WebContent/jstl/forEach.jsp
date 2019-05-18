<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
	<%
		List<String> strList = new ArrayList<String>();
		strList.add("Tom");
		strList.add("Jerry");
		strList.add("Mario");
		request.setAttribute("strList", strList);
		request.setAttribute("strList", strList);
	%>
	
	<c:forEach items="${strList }" var="str">
		${str } <br/>
	</c:forEach>
	
	<%
		Map<String, String> strMap = new HashMap<String, String>();
		strMap.put("name", "Lucy");
		strMap.put("age", "18");
		strMap.put("addr", "China");
		strMap.put("email", "lucy@qq.com");
		
		session.setAttribute("strMap", strMap);
	%>
	
	<c:forEach items="${strMap }" var="entry">
		${entry.key }:${entry.value } <br/>
	</c:forEach>
	
	
	
	
	
	
</body>
</html>
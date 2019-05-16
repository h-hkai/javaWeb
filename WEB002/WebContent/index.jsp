<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" buffer="0kb" %>
<%@page errorPage="/error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/include.jsp" %>

	<%
		int x = 1;
		System.out.print(x);
	%>
	
	<%!
		List list = new ArrayList();
	%>
	
	<%
		out.write("bulabula!");
		response.getWriter().write("calacala!");
	%>
	
	<%=x %>
	<h1>Hello JSP!</h1>
	
	<%
		request.setAttribute("name", "Tom");
		pageContext.setAttribute("name", "Mario", PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("name", "Jerry", PageContext.SESSION_SCOPE);
		pageContext.setAttribute("name", "Doreamon", PageContext.APPLICATION_SCOPE);
	%>
	
	<%=request.getAttribute("name") %>
	<%=pageContext.getAttribute("name", PageContext.REQUEST_SCOPE) %>
	
	<%=pageContext.findAttribute("name") %>
	
	<%
		pageContext.getRequest();
		pageContext.getOut();

	%>
	
	
</body>
</html>
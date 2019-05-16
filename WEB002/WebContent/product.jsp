<%@page import="domain.User"%>
<%@page import="java.util.List"%>
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
		List<User> productList = (List<User>)request.getAttribute("productList");
		if (productList != null) {
			for (User product : productList) {
				out.write("<h1>"+product.toString()+"</h1>");
			}
		}

	%>

	 
</body>
</html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="el.User"%>
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
		request.setAttribute("company", "googel");
		
		User user = new User();
		user.setId(1);
		user.setName("Jerry");
		user.setPassword("123456");
	
		session.setAttribute("user", user);
		
		List<User> list = new ArrayList<User>();
		User user1 = new User();
		user1.setId(2);
		user1.setName("Mario");
		user1.setPassword("1234567");
		list.add(user1);
		
		User user2 = new User();
		user2.setId(3);
		user2.setName("Monkey King");
		user2.setPassword("12345678");
		list.add(user2);
		application.setAttribute("list", list);
		
	%>
	
	<%=request.getAttribute("company") %>
	<%
		User sessionUser = (User)session.getAttribute("user");
		out.write(sessionUser.getName());
	%>
	<hr/>
	
	${requestScope.company }
	${sessionScope.user.name }
	${applicationScope.list[1].name }
	<hr/>
	
	${company }
	${user.name }
	${list[1].name }
	<hr/>
	
	${1+1 }
	${1==1?true:false }
	<hr/>
	
	${empty ""}
	${empty user }
	
	
	
	
	

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/13
  Time: 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>default jsp</title>
</head>
<body>

<%
    /*重定向到indexServlet*/
    response.sendRedirect(request.getContextPath()+"/product?method=index");
%>
</body>
</html>

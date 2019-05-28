<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/encodeServlet" method="get">
		<input type="text" name="user"><br>
		<input type="submit" value="submit"><br>
	</form>
</body>
</html>
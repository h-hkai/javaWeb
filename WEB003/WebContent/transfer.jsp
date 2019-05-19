<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="TransferServlet" method="post">
		Transfer out account: <input type="text" name="out"><br/>
		Transfer int account: <input type="text" name="in"><br/>
		Transfer amount: <input type="text" name="amount"><br/>
		<input type="submit" value="submit">
	</form>

</body>
</html>
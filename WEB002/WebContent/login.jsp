<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	window.onload=function() {
		changeImg();
	}

	function changeImg(obj) {
		obj.src="/WEB002/VerifyCodeServlet?time=" + new Date().getTime();
	}

</script>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
			out.print(msg);
		}
	%>

	<form action="/WEB002/LoginError" method="post">
		<div><%=request.getAttribute("loginInfo")==null?"":request.getAttribute("loginInfo")%></div>
		<div><%=request.getAttribute("verifyCodeInfo")==null?"":request.getAttribute("verifyCodeInfo")%></div>
		用户名：<input type="text" name="username" /> <br /> 
		密码：<input type="password" name="password" /> <br /> 
		验证码：<input type="text" name="verifyCode" size="5" /> 
		<img src="/WEB002/VerifyCodeServlet" onclick="changeImg(this)"/> <br /> 
		<input type="submit" value="提交" />
	</form>
</body>
</html>
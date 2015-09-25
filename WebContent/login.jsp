<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body bgcolor=blue>
<center>
<br/>
<h2>用户登录</h2><br/><br/>
	<form action="login_handler.jsp" method="post" class="form-inline">
		用户名:<input type="text" name="name"/><br/><br/>
		密&nbsp;码：<input type="password" name="pwd"/><br/><br/>
		<input type="submit" value="登陆"/>&nbsp;&nbsp;&nbsp;
		<input type="reset" value="重置"/>
	</form>
	<p>没有账号？<a href="register.jsp">点击注册</a></p>
	</center>
</body>
</html>
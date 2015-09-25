<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册</title>
		<script type="text/javascript" src="register.js"></script>
	</head>
<body>
		<form action="CountServlet?method=add" id="form1" method="post">
			用户名：&nbsp;&nbsp;<input onblur="chechName(this);" type="text" id = "name" name="name"/><div style="display: inline;"><font id="font2"></font></div><br/>
			密&nbsp;&nbsp;码：&nbsp;&nbsp;<input onblur="chechP(this);" type="password" id = "pwd1"  name="pwd"/><div style="display: inline;"><font id="font3"></font></div><br/>
			再输入一次密码：<input  onblur="chechPwd(this);" type="password"/><div style="display: inline;"><font id="font1"></font></div><br/>
			用户类型：<input type="radio" value="1" checked="checked" name="type">我要买<input type="radio" value="2" name="type">我要卖<br/>
			<input type="button" onclick="vilidatePwd();" value="提交"/>
		</form>
	</body>
</html>

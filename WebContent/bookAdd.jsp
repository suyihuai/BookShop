<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css">
<title>Insert title here</title>
<script type="text/javascript" src="bookAdd.js"></script>
</head>
<body>
<center></center>
<h2>添加图书</h2>
	<form action="BookServlet?method=add" id="form1" method="post" class="form-inline">
		图书名称:<input type="text" onblur="nameCheck(this)" name="name"/><div style="display: inline;"><font id="font1"></font></div><br/>
		批发价格:<input type="text" onblur="priceCheck(this)" name="ws_price"/><div style="display: inline;"><font id="font2"></font></div><br>
		作者:<input type="text" name="author"/><br/>
		出版社:<input type="text" name="press"/><br>
		封面:<input type="text" name="url"/><br/>
		<input type="button" onclick="vilidate();" value="提交"/>
	</form>
	</center>
</body>
</html>
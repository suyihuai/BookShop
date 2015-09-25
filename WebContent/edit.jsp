<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="edit.js"></script>
</head>
<body>
	<form action="BookServlet?method=update" id="form1" method="post">
		<input type="hidden" name = "bid" value="${book.bid }"/>
		图书名称:<input type="text" onblur="nameCheck(this)" name="name" value="${book.name }"/><div style="display: inline;"><font id="font1"></font></div><br/>
		批发价格:<input type="text" onblur="priceCheck(this)" name="ws_price" value="${book.ws_price }"/><div style="display: inline;"><font id="font2"></font></div><br>
		作者:<input type="text" name="author" value="${book.author }"/><br/>
		出版社:<input type="text" name="press" value="${book.press }"/><br>
		封面:<input type="text" name="url" value="${book.url }"/><br/>
		<input type="button" onclick="vilidate();" value="提交"/>
	</form>
</body>
</html>
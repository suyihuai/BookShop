<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<center>
<h3>订单信息</h3>
	<form action="OrderServlet?flag=add" id="form1" method="post" class="form-inline">
	<input type="hidden" name = "bid" value="${stock.bid }"/>
		图书名称:<input type="text"  name="name" value="${stock.bname }" readonly="readonly"/><div style="display: inline;"><font id="font1"></font></div><br/><br>
		价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格:<input type="text"  name="price" value="${stock.price}" readonly="readonly"/><div style="display: inline;"><font id="font2"></font></div><br><br>
		商&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;铺:<input type="text" name="sname" value="${stock.sname}" readonly="readonly"/><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;购买数量:<input type="text" name="num" />小于${stock.num }<br/><br>
		<input type="submit" value="提交订单"/>
	</form>
	</center>
</body>
</html>
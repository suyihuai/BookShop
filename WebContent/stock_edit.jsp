<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.vince.entity.Stock"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="StockServlet?flag=update" method="post">
	<input type="hidden" name="sname" value="${stock.sname }"/>
		图书号：<input type="text" name="bid" value="${stock.bid }" readonly="readonly"/><br/>
		图书名称：<input type="text" name="bname" value="${stock.bname }" readonly="readonly"/><br/>
		库存量：<input type="text" name="num" value="${stock.num }" readonly="readonly"/><br/>
		售价：<input type="text" name="price" value="${stock.price }"/><br/>
		<input type="submit" value="确认修改"/>
	</form>
</body>
</html>
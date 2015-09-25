<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>

	<a href="seller.jsp">返回</a>
	<center>
	<h3>订单</h3>
	<table border="1px" class="table-condensed">
		<tr>
			<th>订单编号  </th>
			<th>图书编号</th>
			<th>单价</th>
			<th>购买数量</th>
			<th>出售账号</th>
			<th>买家账号</th>
		</tr>
		<c:forEach items="${requestScope.list }" var="order">
		<tr>
			<td>${order.id}</td>
			<td>${order.bid }</td>
			<td>${order.price }</td>
			<td>${order.num }</td>
			<td>${order.sname }</td>
			<td>${order.uname }</td>
		</tr>
		</c:forEach>
	</table>
	</center>
</body>
</html>
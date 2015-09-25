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
<a href="customer.jsp">返回首页</a>
<center>

<h4>选择购买</h4>
<table border="1px" class="table-condensed">
		<tr>
			<th>图书号</th>
			 <th>图书名称</th>
			<th>库存量</th>
			<th>商铺账号</th>
			<th>单价</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.list }" var="w">
		<tr>
			<td>${w.bid}</td>
			<td>${w.bname}</td>
			<td>${w.num }</td>
			<td>${w.sname }</td>
			<td>${w.price}</td>
			<td><a href="StockServlet?flag=findById&bid=${w.bid }&sname=${w.sname}">购买</a></td>
		</tr>
		</c:forEach>
	</table>
	</center>
	<%
		int bid = Integer.parseInt(request.getParameter("bid"));
	%>
</body>
</html>
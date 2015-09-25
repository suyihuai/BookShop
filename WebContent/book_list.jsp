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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="manager.jsp">返回</a>
<center>

<br/>
<h2>所有图书信息列表</h2><br/>
	<table border="1px" class="table-condensed">
		<tr>
			<th>图书号</th>
			<th>图书名称</th>
			<th>披发价格</th>
			<th>作者</th>
			<th>出版社</th>
			<th>封面</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.list }" var="book">
		<tr>
			<td>${book.bid }</td>
			<td>${book.name}</td>
			<td>${book.ws_price }</td>
			<td>${book.author }</td>
			<td>${book.press }</td>
			<td>${book.url }</td>
			<td><a href="BookServlet?method=find&bid=${book.bid }">修改</a>/<a href="BookServlet?method=delete&bid=${book.bid }">删除</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="7"><a href="bookAdd.jsp">添加</a></td>
		</tr>
	</table>
	</center>
</body>
</html>
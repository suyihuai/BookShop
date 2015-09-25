<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.vince.dao.BookDao,com.vince.dao.WholesaleDao,com.vince.daoimpl.WholesaleDaoImpl,com.vince.daoimpl.BookDaoImpl,java.util.List,com.vince.entity.*,java.sql.SQLException"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css">
<title>进货表单</title>
</head>
<body>
<center>
<h2>入库表单</h2>
	<table border="1px" class="table-condensed">
		<tr>
			<th>入库单编号</th>
			<th>图书号</th>
			 <th>图书名称</th>
			<th>购入价格</th>
			<th>购入数量</th>
			<th>购买账号</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.list }" var="w">
		<tr>
			<td>${w.id }</td>
			<td>${w.bid}</td>
			<td>${w.bname}</td>
			<td>${w.price}</td>
			<td>${w.num }</td>
			<td>${w.sname }</td>
			<td><a href="WholesaleServlet?flag=find&id=${w.id }">修改</a>/<a href="WholesaleServlet?flag=delete&id=${w.id }">删除</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<jsp:include page="pageroll.jsp" flush="true">
				 <jsp:param value="WholesaleServlet?flag=findBySname" name="action"/>
				</jsp:include>
			</td>
		</tr>
	</table><br/>
	<a href="seller.jsp">返回</a>
</body>
</center>
</html>
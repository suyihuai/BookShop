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
<!--  String sql = "select * "+
					 "from (select * from ShowNewGoods order by ontime desc)"+
					 "where goodsid not in(select goodsId "+
					 					   "from (select * "+
					 					   		  "from ShowNewGoods order by ontime desc) "+
					 					   		  "where rownum <= ?) and rownum <= 12";
					 					   		  -->
<center>
<h2>库存信息列表</h2>
	<table border="1px" class="table-condensed">
		<tr>
			<th>图书编号</th>
			<th>图书名称</th>
			<th>库存量</th>
			<th>售价</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.list }" var="stock">
		<tr>
			<td>${stock.bid }</td>
			<td>${stock.bname }</td>
			<td>${stock.num }</td>
			<td>${stock.price }</td>
			<td><a href="StockServlet?flag=findByIS&bid=${stock.bid }&sname=${stock.sname}">更改售价</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<jsp:include page="pageroll.jsp" flush="true">
				 <jsp:param value="StockServlet?flag=findBySname" name="action"/>
				</jsp:include>
			</td>
		</tr>
	</table>
	</center>
</body>
</html>
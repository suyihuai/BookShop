<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号列表</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<a href="manager.jsp"> 返回</a>
<br/>
<h2 align="center">所有账号信息列表</h2><br/>
<center>
<table border="1px" class="table-condensed" >
		<tr>
			<th>用户名</th>
			<th>用户类型</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.list }" var="count">
		<tr>
			<td align="center">${count.name}</td>
			<td align="center">${count.type }</td>
			<td align="center"><a href="CountServlet?method=find&name=${count.name }">修改</a>/<a href="CountServlet?method=delete&name=${count.name }">删除</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<jsp:include page="pageroll.jsp" flush="true">
				 <jsp:param value="CountServlet?method=list" name="action"/>
				</jsp:include>
			</td>
		</tr>
	</table>
	</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.vince.dao.BookDao,com.vince.daoimpl.BookDaoImpl,java.util.List,com.vince.entity.Book,java.sql.SQLException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<% 
	HttpServletRequest req = (HttpServletRequest)request;
	String name = (String) req.getSession().getAttribute("name");
	if(name==null){
		%>
		<a href="login.jsp">登录</a>
		<%
	}else{
		out.print("欢迎您，"+name);
		%>
		<a href="quit.jsp">退出登录</a>
		<a href="OrderServlet?flag=findByUname&uname=<%=name%>">我的订单</a>
		<% 
	}
%>
	<h2>欢迎来云书城</h2>
	<%
		BookDao dao = new BookDaoImpl(); 
		for(Book b : dao.findAll() ){
			%>
			<div style="display: inline;">
			<a href="StockServlet?flag=findByBid&bid=<%=b.getBid()%>"><img alt="" src="<%=b.getUrl()%>"></a>
			<a href="StockServlet?flag=findByBid&bid=<%=b.getBid()%>"><%=b.getName() %></a>
			</div>
			
			<%
		}
	%>
</body>
</html>
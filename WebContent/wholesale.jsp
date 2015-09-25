<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.vince.dao.BookDao,com.vince.daoimpl.BookDaoImpl,java.util.List,com.vince.entity.Book,java.sql.SQLException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<%
	HttpServletRequest req = (HttpServletRequest)request;
	String sname = (String) req.getSession().getAttribute("name");
	System.out.println(sname);
	%>
	<center>
	<h2>批发图书</h2><br/>
	<form action="WholesaleServlet" method="get" class="form-inline"> 
	<input type="hidden" name="flag" value="add"/>
	
	订购账号：<input type="text" name="sname" value="<%=sname %>" readonly="readonly"/><br/>
	书&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：
	<select name="bid">
		<%
		BookDao dao = new BookDaoImpl(); 
		for(Book b : dao.findAll() ){
			%>
			<option value ="<%=b.getBid()%>"><%=b.getName() %></option>
			<%
		}
	%>
		
	</select>
	<br/>
	进货数量：<input type = "text" name = "num"/><br/>
			<input type="submit" value="确定订购">&nbsp;&nbsp;
	</form>
	</center>
</body>
</html>
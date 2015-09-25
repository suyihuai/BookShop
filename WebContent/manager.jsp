<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    HttpServletRequest req = (HttpServletRequest)request;
	String name = (String) req.getSession().getAttribute("name");
	if(name==null){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统管理</title>
</head>
<body>
<% 
	HttpServletRequest requ = (HttpServletRequest)request;
	String rname = (String) requ.getSession().getAttribute("name");
	if(rname==null){
		response.sendRedirect("login.jsp");
	}else{
		out.print("欢迎您，"+rname);
		%>
		<a href="quit2.jsp">退出登录</a><br/>
		<% 
	}
%>
<center>
	<h2>系统管理界面</h2>
	<table border="2px">
	<tr>
	<td  WIDTH=150px height="30" align="center" >
	<a href="CountServlet?method=list">所有用户账号信息</a>
	</td>
	<td WIDTH=150px align="center" >
	<a href="BookServlet?method=findAll">图书信息管理</a>
	</td>
	</tr>
	</table>
	</center>
</body>
</html>
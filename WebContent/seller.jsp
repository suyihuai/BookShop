<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商铺首页</title>
</head>
<body>
<% 
	HttpServletRequest req = (HttpServletRequest)request;
	String name = (String) req.getSession().getAttribute("name");
	if(name==null){
		response.sendRedirect("login.jsp");
	}else{
		out.print("欢迎您，"+name);
		%>
		<a href="quit2.jsp">退出登录</a><br/>
		<% 
	}
%>
<br/><br/><br/>
<center>
<table border="1px">
<tr>
<th>
	<a href="wholesale.jsp">添加图书</a></th>
	<th><a href="WholesaleServlet?flag=findBySname&sname=${name}">查看进货单</a></th>
	<th><a href="OrderServlet?flag=findBySname">查看订单</a></th>
	<th><a href="StockServlet?flag=findBySname">查看库存</a></th>
</tr>
</table>
</center>
</body>
</html>
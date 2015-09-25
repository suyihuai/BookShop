<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.vince.entity.Wholesale,com.vince.dao.WholesaleDao,com.vince.daoimpl.WholesaleDaoImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int bid = Integer.parseInt(request.getParameter("bid"));
	int num = Integer.parseInt(request.getParameter("num"));
	String sname  = request.getParameter("sname");
	//HttpServletRequest req = (HttpServletRequest)request;
	//String sname = (String) req.getSession().getAttribute("name");
	Wholesale w = new Wholesale(bid,num,sname);
	System.out.println(w);
	WholesaleDao dao = new WholesaleDaoImpl();
	dao.add(w);
	response.sendRedirect("Wholesale_list.jsp");
	%>
</body>
</html>
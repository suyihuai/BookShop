<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.vince.entity.Count,com.vince.dao.CountDao,com.vince.daoimpl.CountDaoImpl" %>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	
	CountDao dao = new CountDaoImpl();
	Count c = dao.findByName(name);
	if(c!=null&&pwd.equals(c.getPassword())){
		session.setAttribute("name", name);
		System.out.println("login.....");
		if(c.getType().equals("1")){
			response.sendRedirect("customer.jsp");
		}else if(c.getType().equals("2")){
			response.sendRedirect("seller.jsp");
		}else if(c.getType().equals("3")){
			response.sendRedirect("manager.jsp");
		}
	}else{
		response.sendRedirect("error.jsp");
	}
%>
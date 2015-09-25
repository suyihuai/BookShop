package com.vince.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vince.dao.OrderDao;
import com.vince.dao.StockDao;
import com.vince.daoimpl.OrderDaoImpl;
import com.vince.daoimpl.StockDaoImpl;
import com.vince.entity.Order;
import com.vince.entity.Stock;

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost...");
		HttpServletRequest req = (HttpServletRequest)request;
		String name = (String) req.getSession().getAttribute("name");
		
		if(name==null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		String method = request.getParameter("flag");
		System.out.println(method);
		if(method.equals("findAll")){
			findAll(request,response);
		}else if("find".equals(method)){
			find(request,response);
		}else if("update".equals(method)){
			update(request, response);
		}else if("add".equals(method)){
			add(request, response);
		}else if("delete".equals(method)){
			delete(request, response);
		}else if("findByUname".equals(method)){
			findByUname(request, response);
		}
		else if("findBySname".equals(method)){
			findBySname(request, response);
		}
	}
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao dao = new OrderDaoImpl();
		StockDao dao1 = new StockDaoImpl();
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bname = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		HttpServletRequest req = (HttpServletRequest)request;
		String uname = (String) req.getSession().getAttribute("name");
		String sname = request.getParameter("sname");
		int num = Integer.parseInt(request.getParameter("num"));
		
		Stock s;
		try {
			s = dao1.findById(bid, sname);
			int renum = s.getNum()-num;
			Stock stock = new Stock(bid,sname,renum,bname,price);
			dao1.update1(stock);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Order o = new Order(bid,bname,price,num,uname,sname);
		System.out.println(o);
		try {
			dao.add(o);
			request.setAttribute("order", o);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		OrderDao dao = new OrderDaoImpl();
		try {
			Order o = dao.findById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void findBySname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest)request;
		String name = (String) req.getSession().getAttribute("name");
		System.out.println(name);
		OrderDao dao = new OrderDaoImpl();
		try {
			List<Order> list = dao.findBySname(name);
			request.setAttribute("list", list);
			request.getRequestDispatcher("sorder_list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected void findByUname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest)request;
		String name = (String) req.getSession().getAttribute("name");
		System.out.println(name);
		OrderDao dao = new OrderDaoImpl();
		try {
			List<Order> list = dao.findByUname(name);
			request.setAttribute("list", list);
			request.getRequestDispatcher("uorder_list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

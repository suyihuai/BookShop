package com.vince.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vince.base.PageRoll;
import com.vince.dao.OrderDao;
import com.vince.dao.StockDao;
import com.vince.daoimpl.OrderDaoImpl;
import com.vince.daoimpl.StockDaoImpl;
import com.vince.entity.Order;
import com.vince.entity.Stock;


public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public StockServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest)request;
		String name = (String) req.getSession().getAttribute("name");
		if(name==null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		//²Ù×÷ÑéÖ¤
		String method = request.getParameter("flag");
		System.out.println(method);
		if(method.equals("findAll")){
			findAll(request,response);
		}else if("findByBid".equals(method)){
			findByBid(request,response);
		}else if("update".equals(method)){
			update(request, response);
		}else if("add".equals(method)){
			add(request, response);
		}else if("delete".equals(method)){
			delete(request, response);
		}else if("findById".equals(method)){
			findById(request, response);
		}else if("findBySname".equals(method)){
			findBySname(request, response);
		}else if("findByIS".equals(method)){
			findByIS(request, response);
		}
	}
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDao dao = new StockDaoImpl();
		Stock s = new Stock();
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDaoImpl dao = new StockDaoImpl();
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bname = request.getParameter("bname");
		String sname = request.getParameter("sname");
		int num = Integer.parseInt(request.getParameter("num"));
		float price = Float.parseFloat(request.getParameter("price"));
		Stock s = new Stock(bid,sname,num,bname,price);
		try {
			dao.update1(s);
			request.getRequestDispatcher("StockServlet?flag=findBySname").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void findByBid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDaoImpl dao = new StockDaoImpl();
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		try {
			List<Stock> list = dao.findByBid(bid);
			request.setAttribute("list", list);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDaoImpl dao = new StockDaoImpl();
		int bid = Integer.parseInt(request.getParameter("bid"));
		String sname = request.getParameter("sname");
		
		try {
			Stock s = dao.findById(bid,sname);
			request.setAttribute("stock", s );
			request.getRequestDispatcher("ensure.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void findByIS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDaoImpl dao = new StockDaoImpl();
		int bid = Integer.parseInt(request.getParameter("bid"));
		String sname = request.getParameter("sname");
		
		try {
			Stock s = dao.findById(bid,sname);
			request.setAttribute("stock", s );
			request.getRequestDispatcher("stock_edit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void findBySname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest)request;
		String name = (String) req.getSession().getAttribute("name");
		System.out.println(name);
		String currPage = request.getParameter("currPage");
		PageRoll pageRoll = new PageRoll();
		if(currPage!=null){
			pageRoll.setCurrPage(Integer.parseInt(currPage));
		}
		StockDao dao = new StockDaoImpl();
		try {
			List<Stock> list = dao.findBySname(pageRoll,name);
			request.setAttribute("list", list);
			request.setAttribute("pageRoll", pageRoll);
			request.getRequestDispatcher("stock_list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}

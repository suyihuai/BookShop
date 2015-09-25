package com.vince.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vince.base.PageRoll;
import com.vince.dao.BookDao;
import com.vince.dao.StockDao;
import com.vince.dao.WholesaleDao;
import com.vince.daoimpl.BookDaoImpl;
import com.vince.daoimpl.WholesaleDaoImpl;
import com.vince.entity.Book;
import com.vince.entity.Stock;
import com.vince.daoimpl.StockDaoImpl;
import com.vince.entity.Wholesale;

 public class WholesaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public WholesaleServlet() {
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
		if(method.equals("findBySname")){
			findBySname(request,response);
		}else if("find".equals(method)){
			find(request,response);
		}else if("update".equals(method)){
			update(request, response);
		}else if("add".equals(method)){
			add(request, response);
		}else if("delete".equals(method)){
			delete(request, response);
		}else if("findByBid".equals(method)){
			findByBid(request, response);
		}
	}
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WholesaleDao dao = new WholesaleDaoImpl();
		BookDao dao2 = new BookDaoImpl();
		StockDao dao3 = new StockDaoImpl();
		int bid = Integer.parseInt(request.getParameter("bid"));
		try {
			Book b = dao2.findById(bid);
		String bname = b.getName();
		float price = b.getWs_price();
		float price2 = price+5;
		int num = Integer.parseInt(request.getParameter("num"));
		
		String sname  = request.getParameter("sname");
		//HttpServletRequest req = (HttpServletRequest)request;
		//String sname = (String) req.getSession().getAttribute("name");
		Wholesale w = new Wholesale(bid,bname,price,num,sname);
		Stock s  = new Stock(bid,sname,num,bname,price2);
		try {
			dao.add(w);
			dao3.add(s);
			request.getRequestDispatcher("WholesaleServlet?flag=findBySname&sname="+sname).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		WholesaleDao dao = new WholesaleDaoImpl();
		HttpServletRequest req = (HttpServletRequest)request;
		String name = (String) req.getSession().getAttribute("name");
		try {
			dao.delete(Integer.parseInt(id));
			response.sendRedirect("WholesaleServlet?flag=findBySname&sname="+name);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		int num = Integer.parseInt(request.getParameter("num"));
		String sname = request.getParameter("sname");
		
		
		Wholesale w = new Wholesale(id,bid,num,sname);  
		
		WholesaleDao dao = new WholesaleDaoImpl();
		try {
			dao.update(w);
			response.sendRedirect("WholesaleServlet?method=findAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void findByBid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int bid = Integer.parseInt(request.getParameter("bid"));
	WholesaleDao dao = new WholesaleDaoImpl();
	try {
		List<Wholesale> list = dao.findByBid(bid);
		request.setAttribute("list", list);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	} catch (SQLException e) {
		e.printStackTrace();		
	}
	}
	protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		WholesaleDao dao = new WholesaleDaoImpl();
		try {
			Wholesale w = dao.findById(Integer.parseInt(id));
			request.setAttribute("wholesale", w);
			request.getRequestDispatcher("ensure.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void findBySname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WholesaleDao dao = new WholesaleDaoImpl(); 
		String currPage = request.getParameter("currPage");
		PageRoll pageRoll = new PageRoll();
		if(currPage!=null){
			pageRoll.setCurrPage(Integer.parseInt(currPage));
		}
		HttpServletRequest req = (HttpServletRequest)request;
		String sname = (String) req.getSession().getAttribute("name");
		try {
			List<Wholesale> list = dao.list(pageRoll,sname);
			request.setAttribute("list", list);
			request.setAttribute("pageRoll", pageRoll);
			request.getRequestDispatcher("wholesale_list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

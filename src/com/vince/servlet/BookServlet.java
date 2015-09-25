package com.vince.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vince.dao.BookDao;
import com.vince.daoimpl.BookDaoImpl;
import com.vince.entity.Book;


public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BookServlet() {
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
		String method = request.getParameter("method");
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
		}
	}
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao dao = new BookDaoImpl();
		String name = request.getParameter("name");
		float ws_price = Float.parseFloat(request.getParameter("ws_price"));
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String url = request.getParameter("url");
		Book b = new Book(name,ws_price,author,press,url);
		try {
			dao.add(b);
			response.sendRedirect("BookServlet?method=findAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		BookDao dao = new BookDaoImpl();
		try {
			dao.delete(Integer.parseInt(bid));
			response.sendRedirect("BookServlet?method=findAll");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		String name = request.getParameter("name");
		float ws_price = Float.parseFloat(request.getParameter("ws_price"));
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String url = request.getParameter("url");
		
		Book b = new Book(bid,name,ws_price,author,press,url);  
		
		BookDao dao = new BookDaoImpl();
		try {
			dao.update(b);
			response.sendRedirect("BookServlet?method=findAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		BookDao dao = new BookDaoImpl();
		try {
			Book b = dao.findById(Integer.parseInt(bid));
			request.setAttribute("book", b);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao dao = new BookDaoImpl(); 
		try {
			List<Book> list = dao.findAll();
			for(Book b:list){
				System.out.println(b);
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("book_list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

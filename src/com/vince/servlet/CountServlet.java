package com.vince.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vince.base.PageRoll;
import com.vince.dao.CountDao;
import com.vince.daoimpl.CountDaoImpl;
import com.vince.entity.Count;

/**
 * Servlet implementation class CountServlet
 */
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CountServlet() {
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
		//操作验证
		String method = request.getParameter("method");
		
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
		}else if("list".equals(method)){
			list(request, response);
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CountDao dao = new CountDaoImpl();
		try {
			List<Count> list = dao.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("count_list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		CountDao dao = new CountDaoImpl();
		try {
			dao.delete(name);
			response.sendRedirect("CountServlet?method=findAll");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CountDao dao = new CountDaoImpl();
		String name = request.getParameter("name");
		String pwd  = request.getParameter("pwd");
		String type = request.getParameter("type");
		Count c = new Count(name,pwd,type);
		try {
			System.out.println(type);
			dao.add(c);
			response.sendRedirect("login.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CountDao dao = new CountDaoImpl();
		//当前页需要从客户端传过来
		String currPage = request.getParameter("currPage");
		PageRoll pageRoll = new PageRoll();
		if(currPage!=null){
			pageRoll.setCurrPage(Integer.parseInt(currPage));
		}
		try {
			List<Count> list = dao.list(pageRoll);
			request.setAttribute("list", list);
			request.setAttribute("pageRoll", pageRoll);
			request.getRequestDispatcher("count_list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

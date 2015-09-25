package com.vince.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.db.JdbcTemplete;
import com.vince.base.PageRoll;
import com.vince.base.ResultSetHandler;
import com.vince.dao.BookDao;
import com.vince.entity.Book;

public class BookDaoImpl implements BookDao {
	private JdbcTemplete jdbcTemplete;

	public BookDaoImpl() {
		jdbcTemplete = new JdbcTemplete();
	}
	@Override
	public void add(Book b) throws SQLException {
		String sql = "insert into book_tab(name,ws_price,author,press,url)values(?,?,?,?,?)";
		jdbcTemplete.update(sql,b.getName(),b.getWs_price(),b.getAuthor(),b.getPress(),b.getUrl());
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "delete from book_tab where id=?";
		jdbcTemplete.update(sql,id);
	}

	@Override
	public void update(Book b) throws SQLException {
		String sql = "update book_tab set name=?,ws_price=?,author=?,press=?,url=? where bid=?";
		jdbcTemplete.update(sql,b.getName(),b.getWs_price(),b.getAuthor(),b.getPress(),b.getUrl(),b.getBid());
	}

	@Override
	public Book findById(int bid) throws SQLException {
		String sql = "select bid,name,ws_price,author,press,url from book_tab where bid=?";
		return (Book) jdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Book b = null;
				if (rs.next()) {
					b = new Book();
					b.setBid(rs.getInt("bid"));
					b.setName(rs.getString("name"));
					b.setWs_price(rs.getFloat("ws_price"));
					b.setAuthor(rs.getString("author"));
					b.setPress(rs.getString("press"));
					b.setUrl(rs.getString("url"));
				}
				return b;
			}
		}, bid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() throws SQLException {
		String sql = "select bid,name,ws_price,author,press,url from book_tab";
		return (List<Book>) jdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Book> list = new ArrayList<Book>();
				Book b = null;
				while(rs.next()) {
					b = new Book();
					b.setBid(rs.getInt("bid"));
					b.setName(rs.getString("name"));
					b.setWs_price(rs.getFloat("ws_price"));
					b.setAuthor(rs.getString("author"));
					b.setPress(rs.getString("press"));
					b.setUrl(rs.getString("url"));
					list.add(b);
				}
				return list;
			}
		});
	}
	@Override
	public List<Book> list(PageRoll pageRoll) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

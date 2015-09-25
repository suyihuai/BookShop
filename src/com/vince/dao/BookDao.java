package com.vince.dao;

import java.sql.SQLException;
import java.util.List;

import com.vince.base.PageRoll;
import com.vince.entity.Book;
import com.vince.entity.Count;

public interface BookDao {
	public void add(Book b) throws SQLException;
	public void delete(int bid) throws SQLException;
	public void update(Book b) throws SQLException;
	public Book findById(int bid) throws SQLException;
	public List<Book> findAll() throws SQLException;
	public List<Book> list(PageRoll pageRoll) throws SQLException;
}

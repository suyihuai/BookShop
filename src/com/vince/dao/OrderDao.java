package com.vince.dao;

import java.sql.SQLException;
import java.util.List;

import com.vince.base.PageRoll;
import com.vince.entity.Count;
import com.vince.entity.Order;

public interface OrderDao {
	public void add(Order o) throws SQLException;
	public void delete(int id) throws SQLException;
	public void update(Order o) throws SQLException;
	public Order findById(int id) throws SQLException;
	public List<Order> findByUname(String uname) throws SQLException;
	public List<Order> findBySname(String sname) throws SQLException;
	public List<Order> findAll() throws SQLException;
	public List<Order> list(PageRoll pageRoll) throws SQLException;
}

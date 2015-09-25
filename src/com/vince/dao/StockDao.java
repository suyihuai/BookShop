package com.vince.dao;

import java.sql.SQLException;
import java.util.List;

import com.vince.base.PageRoll;
import com.vince.entity.Count;
import com.vince.entity.Stock;

public interface StockDao {
	public void add(Stock s) throws SQLException;
	public void delete(int bid,String sname) throws SQLException;
	public void update(Stock s) throws SQLException;
	public void update1(Stock s) throws SQLException;
	public void updatePrice(Stock s) throws SQLException;
	public Stock findById(int bid,String sname) throws SQLException;
	public List<Stock> findBySname(PageRoll pageRoll,String sname) throws SQLException;
	public List<Stock> findAll() throws SQLException;
	public List<Stock> list(PageRoll pageRoll) throws SQLException;
}

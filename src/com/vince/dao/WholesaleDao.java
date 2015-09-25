package com.vince.dao;

import java.sql.SQLException;
import java.util.List;

import com.vince.base.PageRoll;
import com.vince.entity.Count;
import com.vince.entity.Wholesale;

public interface WholesaleDao {
	public void add(Wholesale w) throws SQLException;
	public void delete(int id) throws SQLException;
	public void update(Wholesale w) throws SQLException;
	public Wholesale findById(int id) throws SQLException;
	public List<Wholesale> findAll(String sname) throws SQLException;
	public List<Wholesale> findByBid(int bid) throws SQLException;
	public List<Wholesale> list(PageRoll pageRoll,String sname) throws SQLException;
}

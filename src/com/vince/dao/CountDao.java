package com.vince.dao;

import java.sql.SQLException;
import java.util.List;

import com.vince.base.PageRoll;
import com.vince.entity.Count;


public interface CountDao {
	public void add(Count c)throws SQLException;
	public void delete(String name)throws SQLException;
	public void update(Count c)throws SQLException;
	public Count findByName(String name)throws SQLException;
	public List<Count> findAll()throws SQLException;
	public List<Count> list(PageRoll pageRoll) throws SQLException;
}

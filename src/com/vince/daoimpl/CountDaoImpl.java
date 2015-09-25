package com.vince.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.db.JdbcTemplete;
import com.vince.base.PageRoll;
import com.vince.base.ResultSetHandler;
import com.vince.dao.CountDao;
import com.vince.entity.Count;

public class CountDaoImpl implements CountDao {
	private JdbcTemplete jdbcTemplete;

	public CountDaoImpl() {
		jdbcTemplete = new JdbcTemplete();
	}

	@Override
	public void add(Count c) throws SQLException {
		String sql = "insert into count_tab(name,password,type)values(?,?,?)";
		jdbcTemplete.update(sql,c.getName(),c.getPassword(),c.getType() );
	}

	@Override
	public void delete(String name) throws SQLException {
		String sql = "delete from count_tab where name=?";
		jdbcTemplete.update(sql,name);
	}

	@Override
	public void update(Count c) throws SQLException {
		String sql = "update count_tab set password=?,type=? where name=?";
		jdbcTemplete.update(sql,c.getPassword(),c.getType(),c.getName());
	}

	@Override
	public Count findByName(String name) throws SQLException {
		String sql = "select name,password,type from count_tab where name=?";
		return (Count) jdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Count c = null;
				if (rs.next()) {
					c = new Count();
					c.setName(rs.getString("name"));
					c.setPassword(rs.getString("password"));
					c.setType(rs.getString("type"));
				}
				return c;
			}
		}, name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Count> findAll() throws SQLException {
		String sql = "select name,password,type from count_tab";
		return (List<Count>) jdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Count c = null;
				List<Count> list = new ArrayList<Count>();
				while (rs.next()) {
					c = new Count();
					System.out.println(rs.getString("name") + ":"
							+ rs.getString("password") + ":"
							+ rs.getString("type"));
					c.setName(rs.getString("name"));
					c.setPassword(rs.getString("password"));
					c.setType(rs.getString("type"));
					list.add(c);
				}
				return list;
			}
		});
	}

	@Override
	public List<Count> list(PageRoll pageRoll) throws SQLException {
		String sql = "select count(name) from count_tab";
		String sql2 = "select name,password,type from count_tab limit ?,?";
		Integer count = (Integer)jdbcTemplete.query(sql, new ResultSetHandler(){

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				if(rs.next()){
					Integer count = rs.getInt(1);
					System.out.println(count);
					return count;
				}
				return null;
			}
			
		});
		pageRoll.setTatalCount(count);
		//²éÑ¯·ÖÒ³¼ÇÂ¼
		@SuppressWarnings("unchecked")
		List<Count> list = (List<Count>)jdbcTemplete.query(sql2, new ResultSetHandler(){

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Count> list  = new ArrayList<Count>();
				Count c = null;
				while(rs.next()){
					c = new Count();
					c.setName(rs.getString("name"));
					c.setPassword(rs.getString("password"));
					c.setType(rs.getString("type"));
					list.add(c);
				}
				return list;
			}
			
		},(pageRoll.getCurrPage()-1)*pageRoll.getPageSize(),pageRoll.getPageSize());
		return list;
	}

}

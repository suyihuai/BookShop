package com.vince.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.db.JdbcTemplete;
import com.vince.base.PageRoll;
import com.vince.base.ResultSetHandler;
import com.vince.dao.WholesaleDao;
import com.vince.entity.Count;
import com.vince.entity.Wholesale;

public class WholesaleDaoImpl implements WholesaleDao {
	private JdbcTemplete jdbcTemplete;

	public WholesaleDaoImpl() {
		jdbcTemplete = new JdbcTemplete();
	}
	@Override
	public void add(Wholesale w) throws SQLException {
		String sql = "insert into wholesale_tab(bid,bname,price,num,sname)values(?,?,?,?,?)";
		jdbcTemplete.update(sql,w.getBid(),w.getBname(),w.getPrice(),w.getNum(),w.getSname());
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "delete from wholesale_tab where id=?";
		jdbcTemplete.update(sql,id);
	}

	@Override
	public void update(Wholesale w) throws SQLException {
		
	}

	@Override
	public Wholesale findById(int id) throws SQLException {
		String sql = "select id,bid,bname,price,num,sname from wholesale_tab where id=?";
		return (Wholesale ) jdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Wholesale w = null;
				if (rs.next()) {
					w = new Wholesale();
					w.setId(rs.getInt("id"));
					w.setBid(rs.getInt("bid"));
					w.setBname(rs.getString("bname"));
					w.setPrice(rs.getFloat("price"));
					w.setNum(rs.getInt("num"));
					w.setSname(rs.getString("sname"));
				}
				return w;
			}
		}, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Wholesale> findAll(String sname) throws SQLException {
		
		String sql = "select id,bid,bname,price,num,sname from wholesale_tab where sname=?";
		return (List<Wholesale> ) jdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Wholesale w = null;
				List<Wholesale> list = new ArrayList<Wholesale>();
				while (rs.next()) {
					w = new Wholesale();
					w.setId(rs.getInt("id"));
					w.setBid(rs.getInt("bid"));
					w.setBname(rs.getString("bname"));
					w.setPrice(rs.getFloat("price"));
					w.setNum(rs.getInt("num"));
					w.setSname(rs.getString("sname"));
					list.add(w);
				}
				return list;
			}
		},sname);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Wholesale> findByBid(int bid) throws SQLException {
		
		String sql = "select id,bid,bname,price,num,sname from wholesale_tab where bid=?";
		return (List<Wholesale> ) jdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Wholesale w = null;
				List<Wholesale> list = new ArrayList<Wholesale>();
				while (rs.next()) {
					w = new Wholesale();
					w.setId(rs.getInt("id"));
					w.setBid(rs.getInt("bid"));
					w.setBname(rs.getString("bname"));
					w.setPrice(rs.getFloat("price"));
					w.setNum(rs.getInt("num"));
					w.setSname(rs.getString("sname"));
					list.add(w);
				}
				return list;
			}
		},bid);
	}
	@Override
	public List<Wholesale> list(PageRoll pageRoll,String sname) throws SQLException {
		String sql = "select count(id) from wholesale_tab where sname=?";
		String sql2 = "select id,bid,bname,price,num,sname from wholesale_tab where sname=? limit ?,?";
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
			
		},sname);
		pageRoll.setTatalCount(count);
		//²éÑ¯·ÖÒ³¼ÇÂ¼
		@SuppressWarnings("unchecked")
		List<Wholesale> list = (List<Wholesale>)jdbcTemplete.query(sql2, new ResultSetHandler(){

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Wholesale> list  = new ArrayList<Wholesale>();
				Wholesale w = null;
				while(rs.next()){
					w = new Wholesale();
					w.setId(rs.getInt("id"));
					w.setBid(rs.getInt("bid"));
					w.setBname(rs.getString("bname"));
					w.setPrice(rs.getFloat("price"));
					w.setNum(rs.getInt("num"));
					w.setSname(rs.getString("sname"));
					list.add(w);
				}
				return list;
			}
			
		},sname,(pageRoll.getCurrPage()-1)*pageRoll.getPageSize(),pageRoll.getPageSize());
		return list;
	}

}




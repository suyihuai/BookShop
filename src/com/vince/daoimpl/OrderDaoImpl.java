package com.vince.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.db.DBUtils;
import com.util.db.JdbcTemplete;
import com.vince.base.PageRoll;
import com.vince.base.ResultSetHandler;
import com.vince.dao.OrderDao;
import com.vince.entity.Book;
import com.vince.entity.Order;

public class OrderDaoImpl implements OrderDao {
	private JdbcTemplete jdbcTemplete;

	public OrderDaoImpl() {
		jdbcTemplete = new JdbcTemplete();
	}

	@Override
	public void add(Order o) throws SQLException {
//		String sql = "insert into order0(bid,bname,price,num,uname,sname)values("
//				+ o.getBid()
//				+ ",'"
//				+ o.getBname()
//				+ "',"
//				+ o.getPrice()
//				+ ","
//				+ o.getNum() + ",'" + o.getUname() + "','" + o.getSname() + "')";
//		System.out.println(sql);
		String sql ="insert into order0(bid,bname,price,num,uname,sname)values(?,?,?,?,?,?)";
		 jdbcTemplete.update(sql,o.getBid(),o.getBname(),o.getPrice(),o.getNum(),o.getUname(),o.getSname());
//		Connection conn = null;
//		PreparedStatement ps = null;
//		conn = DBUtils.getConnection();
//		ps = conn.prepareStatement(sql);
//		ps.setInt(1, o.getBid());
//		ps.setString(2, o.getBname());
//		ps.setFloat(3, o.getPrice());
//		ps.setInt(4, o.getNum());
//		ps.setString(5, o.getUname());
//		ps.setString(6, o.getSname());
//		int rs = ps.executeUpdate();
//		if (rs > 0) {
//			System.out.println("≤Â»Î≥…π¶£°£°");
		

	}

	@Override
	public void delete(int id) throws SQLException {

	}

	@Override
	public void update(Order o) throws SQLException {

	}

	@Override
	public Order findById(int id) throws SQLException {
		String sql = "select id,bid,bname,price,num,sname,uname from order0 where id=?";
		return (Order) jdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Order o = null;
				if (rs.next()) {
					o = new Order();
					o.setId(rs.getInt("id"));
					o.setBid(rs.getInt("bid"));
					o.setPrice(rs.getFloat("price"));
					o.setNum(rs.getInt("num"));
					o.setSname(rs.getString("sname"));
					o.setUname(rs.getString("uname"));
				}
				return o;
			}
		}, id);
	}

	@Override
	public List<Order> findAll() throws SQLException {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findByUname(String uname) throws SQLException {
		String sql = "select id,bid,bname,price,num,sname,uname from order0 where uname=?";
		return (List<Order>) jdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Order o = null;
				List<Order> list = new ArrayList<Order>();
				while (rs.next()) {
					o = new Order();
					o.setId(rs.getInt("id"));
					o.setBid(rs.getInt("bid"));
					o.setPrice(rs.getFloat("price"));
					o.setNum(rs.getInt("num"));
					o.setSname(rs.getString("sname"));
					o.setUname(rs.getString("uname"));
					list.add(o);
				}
				return list;
			}
		}, uname);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findBySname(String sname) throws SQLException {
		String sql = "select id,bid,bname,price,num,sname,uname from order0 where sname=?";
		return (List<Order>) jdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Order o = null;
				List<Order> list = new ArrayList<Order>();
				while (rs.next()) {
					o = new Order();
					o.setId(rs.getInt("id"));
					o.setBid(rs.getInt("bid"));
					o.setPrice(rs.getFloat("price"));
					o.setNum(rs.getInt("num"));
					o.setSname(rs.getString("sname"));
					o.setUname(rs.getString("uname"));
					list.add(o);
				}
				return list;
			}
		}, sname);
	}

	@Override
	public List<Order> list(PageRoll pageRoll) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

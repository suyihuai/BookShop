package com.vince.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.db.JdbcTemplete;
import com.vince.base.PageRoll;
import com.vince.base.ResultSetHandler;
import com.vince.dao.StockDao;
import com.vince.entity.Count;
import com.vince.entity.Stock;

public class StockDaoImpl implements StockDao {
	private JdbcTemplete jdbcTemplete;

	public StockDaoImpl() {
		jdbcTemplete = new JdbcTemplete();
	}

	@Override
	public void add(Stock s) throws SQLException {
		
		Stock stock = findById(s.getBid(),s.getSname());
		if(stock==null){
		String sql = "insert into stock(bid,sname,num,bname,price)values(?,?,?,?,?)";
		jdbcTemplete.update(sql,s.getBid(),s.getSname(),s.getNum(),s.getBname(),s.getPrice());
		}else{
			update(s);
		}
	}

	@Override
	public void delete(int bid, String sname) throws SQLException {
		
	}

	@Override
	public void update(Stock s) throws SQLException {
		Stock stock = findById(s.getBid(), s.getSname());
		int num = stock.getNum()+s.getNum();
		System.out.println("num="+num);
		String sql = "update stock set num=? where bid=? and sname=?";
		jdbcTemplete.update(sql,num,s.getBid(),s.getSname());
	}

	@Override
	public Stock findById(int bid, String sname) throws SQLException {
		String sql = "select bid,sname,num,bname,price from stock where bid=? and sname=?";
		return (Stock) jdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Stock s = null;
				if (rs.next()) {
					s = new Stock();
					s.setBid(rs.getInt("bid"));
					s.setSname(rs.getString("sname"));
					s.setNum(rs.getInt("num"));
					s.setBname(rs.getString("bname"));
					s.setPrice(rs.getFloat("price"));
				}
				return s;
			}
		}, bid,sname);
	}

	@Override
	public List<Stock> findAll() throws SQLException {
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<Stock> findByBid(int bid) throws SQLException{
		
		String sql = "select bid,sname,num,bname,price from stock where bid=?";
		return (List<Stock>) jdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Stock s = null;
				List<Stock> list = new ArrayList<Stock>();
				while (rs.next()) {
					s = new Stock();
					s.setBid(rs.getInt("bid"));
					s.setSname(rs.getString("sname"));
					s.setNum(rs.getInt("num"));
					s.setBname(rs.getString("bname"));
					s.setPrice(rs.getFloat("price"));
					list.add(s);
				}
				return list;
			}
		}, bid);
	}

	@Override
	public void update1(Stock s) throws SQLException {
		String sql = "update stock set num=?,price=? where bid=? and sname=?";
		jdbcTemplete.update(sql,s.getNum(),s.getPrice(),s.getBid(),s.getSname());
	}
	@Override
	public List<Stock> findBySname(PageRoll pageRoll,String sname) throws SQLException {
		String sql = "select count(sname) from stock where sname=?";
		String sql2 = "select bid,sname,num,bname,price from stock where sname=? limit ?,?";
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
		List<Stock> list = (List<Stock>)jdbcTemplete.query(sql2, new ResultSetHandler(){

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<Stock> list  = new ArrayList<Stock>();
				Stock s = null;
				while(rs.next()){
					s = new Stock();
					s.setBid(rs.getInt("bid"));
					s.setSname(rs.getString("sname"));
					s.setNum(rs.getInt("num"));
					s.setBname(rs.getString("bname"));
					s.setPrice(rs.getFloat("price"));
					list.add(s);
				}
				return list;
			}
			
		},sname,(pageRoll.getCurrPage()-1)*pageRoll.getPageSize(),pageRoll.getPageSize());
		return list;
	}

	@Override
	public List<Stock> list(PageRoll pageRoll) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePrice(Stock s) throws SQLException {
		
	}

}

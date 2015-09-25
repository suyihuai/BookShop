package com.util.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vince.base.ResultSetHandler;

public class JdbcTemplete {

	/**
	 * ʵ����ɾ�ĵĳ���
	 * @param sql
	 * @param args
	 */
	public int update(String sql,Object...args){
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			//����ռλ���Ĳ���
			if(args!=null){
				for (int i = 0; i < args.length; i++) {
					System.out.println(args[i]);
					ps.setObject(i+1, args[i]);
				}
			}
			return ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}finally{
			DBUtils.close(null, ps, conn);
		}
	}
	/**
	 * ��ѯ�����ĳ���
	 * @param sql
	 * @param handler
	 * @param args
	 * @return
	 */
	public Object query(String sql,ResultSetHandler handler,Object...args){
		Connection conn  = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			if(args!=null){
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i+1, args[i]);
				}
			}
			rs = ps.executeQuery();
			return handler.doHandler(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}




















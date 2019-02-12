package dao;


import entity.Member;
import util.C3P0Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	public Member findByCompany(String company)  {
		Member m = null;
		Connection conn = null;
		try {
			conn = C3P0Mysql.getInstance().getConnection();
			String sql = "select username,truename,mobile from gyy_member where company=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, company);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = setMember(rs);
				
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Mysql.close(conn);
		}
		return m;
		
	}
	public Member findByUsername(String username) {
		Member m = null;
		Connection conn = null;
		try {
			conn = C3P0Mysql.getInstance().getConnection();
			String sql = "select username,truename,mobile from gyy_member where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = setMember(rs);
				
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Mysql.close(conn);
		}
		return m;
	}
	private Member setMember(ResultSet rs) throws SQLException{
		Member m = new Member();
		m.setUsername(rs.getString("username"));
		m.setMobile(rs.getString("mobile"));
		m.setTruename(rs.getString("truename"));
		return m;
		
	}
}

package dao;

import entity.Mall_trads;
import util.C3P0Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Mall_tradsDao {

	public List<Mall_trads>findByPage(int page,int pagesize)  {
		List<Mall_trads>list =new ArrayList<Mall_trads>();
		Connection conn = null;
		try {
			conn = C3P0Mysql.getInstance().getConnection();
			int bid = (page-1)*pagesize;
			int eid = page*pagesize;
			double a = eid/500000.0;
			int  index = (int) Math.ceil(a);
			String table_name = "gyy_mall_trads_"+index;
			String sql = "select * from "+table_name+" where id>? and id<=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setInt(2, eid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Mall_trads m = Set_Mall_trads(rs);
				list.add(m);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0Mysql.close(conn);
		}
		return list;
	}
	
	
	private Mall_trads Set_Mall_trads(ResultSet rs) throws SQLException {
		Mall_trads m = new Mall_trads();
		m.setId(rs.getInt("id"));
		m.setCompany(rs.getString("company"));
		m.setAreaname(rs.getString("areaname"));
		m.setProvince(rs.getString("province"));
		m.setCatname(rs.getString("catname"));
		m.setBusiness(rs.getString("business"));
		m.setTitle(rs.getString("title"));
		m.setType(rs.getString("type"));
		m.setSize(rs.getString("size"));
		m.setRegist(rs.getString("regist"));
		m.setNum(rs.getInt("num"));
		m.setAmount(rs.getInt("amount"));
		m.setNeed(rs.getInt("need"));
		m.setProvide(rs.getInt("provide"));
		m.setSupply(rs.getInt("supply"));
		m.setServices(rs.getInt("services"));
		m.setAsk(rs.getInt("ask"));
		m.setDown(rs.getInt("down"));
		m.setExpress(rs.getInt("express"));
		m.setFinance(rs.getInt("finance"));
		m.setPush(rs.getInt("push"));
		m.setVip(rs.getString("vip"));
		m.setStatus(rs.getInt("status"));
		return m;
	}

	
}

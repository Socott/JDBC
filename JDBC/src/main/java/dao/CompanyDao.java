package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Company;
import util.C3P0Mysql;


public class CompanyDao {
    /**
     * 根据用户名获取公司信息
     * @param username
     * @return
     */
	public Company findByUsername(String username) {
		Company c = null;
		Connection conn = null;
		try {
			conn = C3P0Mysql.getInstance().getConnection();
			String sql = "select username,company,keyword,address,telephone,fax from gyy_company where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = setCompany(rs);
				
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Mysql.close(conn);
		}
		return c;
	}

    /**
     * 根据公司名称获取公司信息
     * @param company
     * @return
     */
    public Company findByCompany(String company) {
        Company c = null;
        Connection conn = null;
        try {
            conn = C3P0Mysql.getInstance().getConnection();
            String sql = "select catid,catids,username,company,keyword,address,telephone,fax from gyy_company where company=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, company);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c = setCompany(rs);

            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            C3P0Mysql.close(conn);
        }
        return c;
    }

	private Company setCompany(ResultSet rs) throws SQLException{
		Company c = new Company();
		c.setUsername(rs.getString("username"));
		c.setCompany(rs.getString("company"));
		c.setKeyword(rs.getString("keyword"));
		c.setAddress(rs.getString("address"));
		c.setTelephone(rs.getString("telephone"));
		c.setTelephone(rs.getString("telephone"));
		c.setFax(rs.getString("fax"));
		c.setCatid(rs.getString("catid"));
		c.setCatids(rs.getString("catids"));
		return c;
		
	}
}

package dao;

import entity.Category;
import util.C3P0Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDao {
    private  Category c;
    public Category findByCatname(int moduleid,String catname){
        Connection conn = null;
        try {
            conn = C3P0Mysql.getInstance().getConnection();
            String sql = "select * from gyy_category where moduleid=?,catname=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, moduleid);
            ps.setString(2, catname);
            ResultSet rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            C3P0Mysql.close(conn);
        }
        return c;
    }

    public Category getAll(int moduleid){

        Connection conn = null;
        try {
            conn = C3P0Mysql.getInstance().getConnection();
            String sql = "select * from gyy_category where moduleid=? and parentid=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, moduleid);
            ps.setInt(2, 0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                c = set(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            C3P0Mysql.close(conn);
        }
        return c;
    }

    private Category set(ResultSet rs) throws SQLException{
        c.setCatid(Integer.parseInt(rs.getString("catid")));
        c.setCatname(rs.getString("catname"));
        return c;
    }

}

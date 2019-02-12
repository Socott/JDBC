package dao;



import entity.GoodsInfo;
import util.C3P0Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsInfoDao {
    //首先匹配分类id

    public GoodsInfo getGoodsInfo(int catid,double money){
        Connection conn = null;
        GoodsInfo goodsInfo = null;
        try {
            conn = C3P0Mysql.getInstance().getConnection();
            //String tableName = "gyy_mallinfo_"+catid;
            String tableName = "gyy_mall";
            //String sql = "select * from "+tableName+" where price <= ? and price >= ? order by rand() limit 1";
            String sql = "select * from "+tableName+" order by rand() limit 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            /*ps.setDouble(1,money*0.5);
            ps.setDouble(2,money*1.5);*/
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                goodsInfo = set(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Mysql.close(conn);
        }
        return goodsInfo;
    }

    private GoodsInfo set(ResultSet rs) throws SQLException{
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setTitle(rs.getString("title"));
        goodsInfo.setPrice(Double.parseDouble(rs.getString("price")));
        return goodsInfo;
    }
}

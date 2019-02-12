package dao;

import entity.BuyerInfo;
import entity.Member;
import util.C3P0Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyerInfoDao {
    /**
     * 根据行业分类获取买家信息
     * @param catid 分类id
     * @param company 需要排除的公司名称
     * @return 返回买家信息
     */
    public BuyerInfo getBuyerInfo(int catid,String company){
        BuyerInfo buyerInfo = null;
        Connection conn = null;
        try {
            conn = C3P0Mysql.getInstance().getConnection();
            String sql = "select username,address from gyy_company  where catids like ? and company <> ? order by rand() limit 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+catid+"%");
            ps.setString(2, company);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                buyerInfo = set(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Mysql.close(conn);
        }

        return buyerInfo;
    }

    private BuyerInfo set(ResultSet rs) throws SQLException{
        BuyerInfo buyerInfo = new BuyerInfo();
        MemberDao memberDao = new MemberDao();
        Member m = memberDao.findByUsername(rs.getString(1));
        buyerInfo.setUsername(rs.getString(1));
        buyerInfo.setAddress(rs.getString(2).replace(" ",""));
        buyerInfo.setMobile(m.getMobile().trim());
        return buyerInfo;
    }
}

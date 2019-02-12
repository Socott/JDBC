package main;

import dao.*;
import entity.*;
import util.C3P0Mysql;
import util.PinYin2Abbreviation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Goods {
    public static void main(String[] args) {
        List<Double> list;
        Member member;
        Company company;
        BuyerInfo buyerInfo;
        GoodsInfo goodsInfo;
        //1.获取源数据
        Mall_tradsDao mallDao = new Mall_tradsDao();
        List<Mall_trads> mall_trads = mallDao.findByPage(1,1);

        //2.名称拼音
        PinYin2Abbreviation pa = new PinYin2Abbreviation();

        CompanyDao companyDao = new CompanyDao();

        MemberDao memberDao = new MemberDao();

        BuyerInfoDao buyerInfoDao = new BuyerInfoDao();

        GoodsInfoDao goodsInfoDao = new GoodsInfoDao();

        //3.公司第一级行业分类
        Map<String,Integer> cm = new HashMap<String, Integer>();
        cm.put("机械设备",29654);
        cm.put("电工电气",29443);
        cm.put("环保",29388);
        cm.put("安防监控",29255);
        cm.put("家用电器",28683);
        cm.put("冶金矿产",28074);
        cm.put("化工原料",27717);
        cm.put("五金模具",27234);
        cm.put("汽摩配件",26946);
        cm.put("家装建材",37220);
        cm.put("印刷",37383);
        cm.put("能源",37415);
        cm.put("包装",37477);
        cm.put("物流",39413);
        cm.put("厨房用具",39405);
        cm.put("食品",39402);


        //价格算法（抢红包）
        RandomPrice rp = new RandomPrice();

        for (Mall_trads m:mall_trads){
            //3.公司拼音名称(卖家公司名)
            String pinyin = pa.cn2py(m.getCompany());

            //5.供应次数(卖出数量)
            int provide = m.getProvide();

            //根据分类名，获得商品的catid
            int catid = cm.get(m.getCatname());

            //6.成交总额
            double amount = m.getAmount();
            member = memberDao.findByCompany(m.getCompany());
            //卖家用户名
            member.getUsername();
            //卖家电话
            member.getMobile();

            company =companyDao.findByCompany(m.getCompany());
            //卖家地址
            company.getAddress();

            list = rp.getPrice(amount,provide);

            Connection connection = null;
            connection = C3P0Mysql.getInstance().getConnection();
            //根据每笔的价格，获取商品(价格算法（抢红包）)

            for (double money:list){
                //根据catid去寻找匹配的买家(卖出数量个买家)需要买家用户名，买家电话，买家地址
                buyerInfo = buyerInfoDao.getBuyerInfo(catid,m.getCompany());
                //System.out.println(buyerInfo);

                //商品信息，需要商品名称，购买的数量，单价
                goodsInfo = goodsInfoDao.getGoodsInfo(catid,money);
                //System.out.println(goodsInfo);

                //卖家公司名
                System.out.println("卖家公司名："+pinyin+"\r\n卖家用户名："+member.getUsername()+"\r\n购买的商品名称："+goodsInfo.getTitle()+"\r\n商品单价："+goodsInfo.getPrice()+"\r\n买家用户名："+buyerInfo.getUsername()+"\r\n买家地址："+buyerInfo.getAddress()+"\r\n买家电话:"+buyerInfo.getMobile());
                System.out.println("---------");

                String sql = "insert into gyy_mall_trads_info_1 (title,price,sell_company,seller,seller_mobile,buyer,buyer_address,buyer_mobile) values (?,?,?,?,?,?,?,?)";
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,goodsInfo.getTitle());
                    preparedStatement.setDouble(2,goodsInfo.getPrice());
                    preparedStatement.setString(3,pinyin);
                    preparedStatement.setString(4,member.getUsername());
                    preparedStatement.setString(5,member.getMobile());
                    preparedStatement.setString(6,buyerInfo.getUsername());
                    preparedStatement.setString(7,buyerInfo.getAddress());
                    preparedStatement.setString(8,buyerInfo.getMobile());
                    preparedStatement.execute();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

            C3P0Mysql.close(connection);
        }
    }

}

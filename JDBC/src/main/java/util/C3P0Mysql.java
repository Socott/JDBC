package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
public class C3P0Mysql {
    private ComboPooledDataSource cpds;
    private static C3P0Mysql c3P0Properties;

    static {
        c3P0Properties = new C3P0Mysql();
    }
    public C3P0Mysql() {
        try {
            //创建连接池
            cpds = new ComboPooledDataSource();
            //加载配置文件,给连接池设置参数
            Properties prop = new Properties();
            prop.load(C3P0Mysql.class.getClassLoader().getResourceAsStream("db.properties"));
            cpds.setDriverClass(prop.getProperty("driver"));
            cpds.setJdbcUrl(prop.getProperty("url"));
            cpds.setUser(prop.getProperty("username"));
            cpds.setPassword(prop.getProperty("password"));
            cpds.setMaxPoolSize(Integer.parseInt(prop.getProperty("max_pool_size")));
            cpds.setMinPoolSize(Integer.parseInt(prop.getProperty("min_pool_size")));
            cpds.setInitialPoolSize(Integer.parseInt(prop.getProperty("init_pool_size")));
            cpds.setMaxStatements(Integer.parseInt(prop.getProperty("max_statements")));
            cpds.setMaxIdleTime(Integer.parseInt(prop.getProperty("max_idle_time")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static C3P0Mysql getInstance(){
        return c3P0Properties;
    }
    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = cpds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 连接池提供的实现类，其close方法内部逻辑是将连接归还给连接池，
     * 即它会清空连接对象中的数据，并且将连接标记为空闲态
     * @param conn
     */
    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("归还连接失败",e);
            }
        }
    }

    /**
     * 连接池提供的实现类，其rollback方法内部逻辑是事务回滚，
     * @param conn
     */
    public static void rollback(Connection conn){
        if(conn != null){
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("归还连接失败",e);
            }
        }
    }
}

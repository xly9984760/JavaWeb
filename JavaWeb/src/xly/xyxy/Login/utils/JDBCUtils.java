package xly.xyxy.Login.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.Login.utils
 * @Author: 99847
 * @CreateTime: 2019-07-24 20:56
 * @Description: 使用Druid的JDBC工具类
 */
public class JDBCUtils {
    private static DataSource ds;
    static {
        Properties pro = new Properties();
        try {
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static DataSource getDataSource() {
        return ds;
    }
}

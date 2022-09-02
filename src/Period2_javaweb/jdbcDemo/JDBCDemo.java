package Period2_javaweb.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther: zhoucan
 * @Date: 2022/8/23-08-23-11:06
 * @Description：Period2_javaweb.jdbcDemo
 */
public class JDBCDemo {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            //1.加载驱动，并注册
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //2.获取连接，连接资源。
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "system");
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(st != null){
                try {
                    st.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }


}

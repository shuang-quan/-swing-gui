package com.JDBC;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    public static Connection getConnection() throws Exception{
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
//        2.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //        3.链接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        return connection;
    }

    /**
     * 关闭资源
     * @param conn
     * @param ps
     */
    public static void closeResourse(Connection conn, Statement ps){
        try {
            if(ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null)
                conn .close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeResourse(Connection conn, Statement ps ,ResultSet rs) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
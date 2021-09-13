package com.test.utils;

import java.sql.*;

/**
 * @Author: Jface
 * @Date: 2021/5/23 20:39
 * @Desc:
 */
//自定义的JDBCUtils工具类, 用来操作: JDBC代码的.
public class JDBCUtils {
    //构造方法,空参私有
    private JDBCUtils() {
    }

    //成员都是静态的.
    //2. 通过静态代码块的方式注册驱动.
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //3. 定义方法, 用来获取连接对象.
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql:///day17", "root", "root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;//如果报错返回null,最后的finally关键字可以省略.
    }

    //4. 释放资源.
    public static void release(Connection conn, Statement stat, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;//GC会优先回收
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                    stat = null;//GC优先回收
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                        conn = null;
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }

        }
    }

}

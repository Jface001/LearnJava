package com.test.demo11_jdbc;

import com.mysql.jdbc.Driver;

import javax.swing.*;
import java.sql.*;

/**
 * @Author: Jface
 * @Date: 2021/5/22 15:26
 * @Desc: 案例: JDBC的入门案例.
 * 数据准备:
 * 详见 day16_随堂sql.sql 文件.
 * JDBC操作数据库:
 * 0. 导入驱动, 只需要做一次.
 * 1. 注册驱动.
 * 2. 获取连接对象.
 * 3. 根据连接对象, 获取可以执行SQL语句的对象.
 * 4. 执行SQL语句, 获取结果集.
 * 5. 操作结果集.
 * 6. 释放资源.
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {
//        1. 注册驱动.
        DriverManager.registerDriver(new Driver());
//        2. 获取连接对象.
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day16", "root", "root");
//        3. 根据连接对象, 获取可以执行SQL语句的对象.
        Statement stat = conn.createStatement();
//        4. 执行SQL语句, 获取结果集.
        String sql = "select * from users;";
        ResultSet rs = stat.executeQuery(sql);
//        5. 操作结果集.
        while (rs.next()) {
            int uid = rs.getInt("uid");
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println(uid + ", " + username + ", " + password);
        }
//        6. 释放资源.
        rs.close();
        stat.close();
        conn.close();


    }

}

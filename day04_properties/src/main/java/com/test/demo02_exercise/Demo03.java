package com.test.demo02_exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: Jface
 * @Date: 2021/5/23 19:49
 * @Desc:
 * 案例: 演示JDBC的快速入门操作.
 * JDBC的核心操作步骤:
 * 0. 导入驱动,  其实就是导入jar包, 只要做一次就行.
 * 1. 注册驱动.
 * 2. 获取连接对象.
 * 3. 根据连接对象, 获取可以执行SQL语句的对象.
 * 4. 执行SQL语句, 获取结果集.
 * 5. 操作结果集.
 * 6. 释放资源.
 */

public class Demo03 {
    public static void main(String[] args) throws Exception {
        //1. 注册驱动.
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接对象.
        Connection conn = DriverManager.getConnection("jdbc:mysql:///day16", "root", "root");
        //3. 根据连接对象, 获取可以执行SQL语句的对象.
        Statement stat = conn.createStatement();
        //4. 执行SQL语句, 获取结果集.
        String sql = "select * from users;";
        ResultSet rs = stat.executeQuery(sql);
        //5. 操作结果集.
        while (rs.next()) {
            System.out.println(rs.getInt("uid") + ", " + rs.getString("username") + ", " + rs.getString("password"));
        }
        //6. 释放资源.
        rs.close();
        stat.close();
        conn.close();

    }


}

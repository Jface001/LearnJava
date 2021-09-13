package com.test.demo11_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: Jface
 * @Date: 2021/5/22 16:37
 * @Desc: 案例: JDBC相关的API详解之 ResultSet接口.
 * <p>
 * ResultSet接口介绍:
 * 概述:
 * 它表示 执行完查询语句后返回的结果集(其实一张表, 里边有一条一条的数据).
 * 成员方法:
 * public boolean next();
 * 判断结果集中是否有下一条数据, 类似于:  Iterator#hasNext().
 * public Xxx getXxx(int columnNumber);
 * 如果有数据, 就根据 列的编号(从1开始), 获取指定列的值, Xxx表示数据类型.
 * public Xxx getXxx(String columnName);
 * 如果有数据, 就根据 列的名字, 获取指定列的值, Xxx表示数据类型
 */
public class Demo06 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day16", "root", "root");
        //3.根据连接对象,获取可以执行SQL语句的对象
        Statement stat = cnn.createStatement();
        //4.执行SQL语句,获取结果集
        String sql = "select * from users;";
        ResultSet rs = stat.executeQuery(sql);
        //5.操作结果集
        System.out.println(rs);
        while (rs.next()) {
            int uid = rs.getInt("uid");
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println(uid + ", " + username + ", " + password);
        }
        //6.释放资源
        rs.close();
        stat.close();
        cnn.close();


    }
}

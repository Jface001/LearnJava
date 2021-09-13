package com.test.demo11_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: Jface
 * @Date: 2021/5/22 15:56
 * @Desc: 案例: JDBC相关的API详解之 DriverManager类.
 * <p>
 * DriverManager类介绍:
 * 概述:
 * 它表示驱动管理者, 主要作用是: 注册驱动 和 获取连接对象.
 * 成员方法:
 * public static void registerDriver(Driver d);
 * 注册驱动, 连接什么数据库, 就传入谁的驱动即可.  这个方法会导致驱动注册两次, 所以没人用.
 * <p>
 * 源码如下:
 * // mysql数据库提供的具体的驱动类               Sun公司提供的JDBC的规范, Driver表示所有的驱动.
 * public class com.mysql.jdbc.Driver implements java.sql.Driver {
 * }
 * public static Connection getConnection(String url, String username, String password);
 * 用来获取连接对象的, 三个参数的解释如下:
 * url: 叫数据库连接字符串, 连接不同的数据库, 格式都不尽相同, 例如: 连接MySQL数据库的格式如下
 * 格式:
 * 协议:子协议://要连接的主机名或者ip地址:端口号/要操作的具体的数据库
 * 示例:
 * jdbc:mysql://localhost:3306/day16
 * jdbc:mysql://127.0.0.1:3306/day16
 * <p>
 * jdbc:mysql:///day16      如果操作的是本机, 则可以写成这个形式.
 * username: 要连接的数据库的 账号
 * password: 要连接的数据库的 密码
 */
public class Demo03 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql:///day16", "root", "root");
        //3.根据连接对象,获取可以执行SQL语句的对象
        Statement state = conn.createStatement();
        //4.执行SQL语句并获取结果
        String sql = "select * from users;";
        ResultSet rs = state.executeQuery(sql);
        //5.操作结果集
        while (rs.next()) {
            int uid = rs.getInt("uid");
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println(uid + ", " + username + ", " + password);
        }
        //6.释放资源
        rs.close();
        state.close();
        conn.close();


    }
}

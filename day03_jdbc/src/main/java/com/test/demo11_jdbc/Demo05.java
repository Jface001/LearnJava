package com.test.demo11_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: Jface
 * @Date: 2021/5/22 16:23
 * @Desc: 案例: JDBC相关的API详解之 Statement接口.
 * Statement接口介绍:
 * 概述:
 * 它表示可以执行SQL语句的对象, 主要功能是: 执行SQL语句 或者 进行批处理管理.
 * 成员方法:
 * 作用1: 执行SQL语句.
 * public ResultSet executeQuery(String sql);
 * 执行查询语句, 获取结果集, 获取的结果是一张表(ResultSet来表示)
 * public int executeUpdate(String sql);
 * 执行更新语句, 获取结果集, 获取的结果是: 受影响的行数(int类型)
 * MySQL中的更新语句指的是: 增, 删, 改.
 * <p>
 * 作用2: 进行批处理管理(目前了解, 后续可能会用到), 批处理只针对于 更新语句有效.
 * public void addBatch(String sql);   添加命令到批处理.
 * public int[] executeBatch();        执行批处理.
 * public void clearBatch();           清空批处理.
 */
public class Demo05 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        Connection cnn = DriverManager.getConnection("jdbc:mysql:///day16", "root", "root");
        //3.根据连接对象,获取可以执行SQL语句的对象
        Statement stat = cnn.createStatement();
        //4.执行SQL语句,获取结果集
        String sql = "select * from users;";
        ResultSet rs = stat.executeQuery(sql);
        //5.操作结果集
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

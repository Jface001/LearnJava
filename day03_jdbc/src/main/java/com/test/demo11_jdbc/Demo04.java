package com.test.demo11_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: Jface
 * @Date: 2021/5/22 16:10
 * @Desc: 案例: JDBC相关的API详解之 Connection接口.
 * Connection接口介绍:
 * 概述:
 * 它表示连接对象, 负责连接 Java代码 和 指定的数据库的, 主要功能是: 获取可以执行SQL语句的对象 以及 管理事务.
 * 成员方法:
 * 作用1: 获取可以执行SQL语句的对象.
 * public Statement createStatement();
 * 获取可以执行SQL语句的对象, 不具有预编译功能, 可能会发生SQL注入攻击问题.
 * public PreparedStatement prepareStatement(String sql);
 * 获取可以执行SQL语句的对象, 具有预编译功能, 能解决SQL注入攻击问题.
 * 作用2: 管理事务(目前了解, 明天上午才会用到)
 * public void setTransactionIsolation(int level);         设置隔离级别.
 * public void commit();                                   提交事务
 * public void rollback();                                 事务回滚
 * public void setAutoCommit(boolean flag);                开启或关闭事务的自动提交功能.
 */
public class Demo04 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        //静态方法,可以之间类名.调用方法
        Connection cnn = DriverManager.getConnection("jdbc:mysql:///day16", "root", "root");
        //3.根据连接对象,获取可以执行SQL语句的对象
        Statement stat = cnn.createStatement();
        //4.执行SQL语句.获取结果集
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

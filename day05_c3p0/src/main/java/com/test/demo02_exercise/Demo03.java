package com.test.demo02_exercise;
import com.test.utils.C3P0Utils;

import java.sql.*;

/**
 * @Author: Jface
 * @Date: 2021/5/24 20:49
 * @Desc:
案例: 演示JDBC操作事务, 模拟转账.

Connection接口 详解:
概述:
表示连接对象, 负责Java和数据库的连接的, 也可以获取: 可以执行SQL语句的对象, 以及进行 事务管理.
作用(成员方法):
1. 获取可以执行SQL语句的对象.
public Statement createStatement();
获取可以执行SQL语句的对象, 不具有预编译功能, 不能解决SQL注入攻击问题.
public PreparedStatement prepareStatement(String sql);
获取可以执行SQL语句的对象, 具有预编译功能, 能解决SQL注入攻击问题.
PreparedStatement接口是 Statement接口的 子接口.

2. 事务管理, 明天讲.
public void setTransactionIsolation(int level); 设置事务的隔离级别
public void commit();   提交事务.
public void rollback(); 事务回滚.
public void setAutoCommit(boolean flag); 开启事务.
 */
public class Demo03 {
    public static void main(String[] args) throws Exception {
        //需求:李白转账给杜甫 1000
        //方式1:不采用事务
        //method01();

        //方式2:采用事务
        Connection conn = null;
        //大括号里面的内容是独立的代码块,代码块内的变量,代码块之外无法使用
        Statement stat = null;
        try {
            //1.获取连接对象
            conn = C3P0Utils.getConnection();
            //2.设置SQL对象,获取可以执行SQL语句的对象
            String sql01 = "update account set money = money-1000 where uid =1; ";
            String sql02 = "update account set money = money+1000 where uid =5; ";
            stat = conn.createStatement();
            //3.执行SQL语句,获取结果集
            //开启事务, 关闭事务的自动提交功能, 相当于开启事务, 什么时候我提交或者回滚事务了, 说明事务结束.
            conn.setAutoCommit(false);
            int a = stat.executeUpdate(sql01);
            int b = stat.executeUpdate(sql02);
            //4.操作结果集
            if(a==b&&a==1){
                conn.commit();//提交事务
                System.out.println("转账成功");
            }else{
                conn.rollback();//事务回滚
                System.out.println("转账失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            C3P0Utils.release(conn,stat,null);
        }
        //5.释放资源





    }

    private static void method01()  {
        Connection conn = null;
        //大括号里面的内容是独立的代码块,代码块内的变量,代码块之外无法使用
        Statement stat = null;

        try {
            //1.创建连接
            conn = C3P0Utils.getConnection();
            //2.设置SQL语句,获取执行SQL语句的对象
            String sql01 = "update account set money = money-1000 where uid =1; ";
            String sql02 = "update account set money = money+1000 where uid =5; ";
            stat = conn.createStatement();
            //3.执行SQL语句
            int a = stat.executeUpdate(sql01);
            int b = stat.executeUpdate(sql02);
            //4.操作结果集
            if(a==b&&a==1){
                System.out.println("转账成功");
            }else{
                System.out.println("操作失败");
            }
            //5.释放资源
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            C3P0Utils.release(conn,stat,null);
        }
    }
}

package com.test.dao;

import com.test.pojo.Item;
import com.test.utils.C3P0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author: Jface
 * @Date: 2021/5/29 20:00
 * @Desc:
定义一个dao层的类,负责和数据库交互
目的: 把爬取到的每页的手机信息(即: list集合), 存储到数据表中.
 */
//定义一个dao层的类,负责和数据库交互
//目的: 把爬取到的每页的手机信息(即: list集合), 存储到数据表中.
public class JdDao {
    public void saveItems(ArrayList<Item> list) {
    //1.获取连接对象
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = C3P0Utils.getConnection();
            //2.定义SQL语句
            String sql = "insert into jd_item values(null,?,?,?,?,?,?,?,?)";
            //3.获取可以执行SQL语句的对象
           ps = conn.prepareStatement(sql);
            //4.执行SQL语句,获取结果集
            for (Item item : list) {
                ps.setLong(1,item.getSku());
                ps.setLong(2,item.getSpu());
                ps.setString(3,item.getTitle());
                ps.setDouble(4,item.getPrice());
                ps.setString(5,item.getPic());
                ps.setString(6,item.getUrl());
                ps.setString(7,item.getCreated());
                ps.setString(8,item.getUpdated());
            }
            int i =ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //5.释放资源
            C3P0Utils.release(conn,ps,null);
        }
    }

}

package com.test.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @Author: Jface
 * @Date: 2021/5/24 20:17
 * @Desc:
 */

//自定义的C3P0Utils工具类.
public class C3P0Utils {
    //1.成员变量,全部私有
    //DataSource: 是JDBC指定的规范, 即所有的数据库连接池对象都是它的子类.
    private static final DataSource ds = new ComboPooledDataSource();
    //2.构造方法,私有

    public C3P0Utils() {
    }

    //3.设置对外提供方法1,提取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
    //4.设置对外提供方法,提供连接对象
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql:///day19_jdspider", "root", "root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //5.释放资源
    public static void release(Connection conn, Statement stat, ResultSet rs){
        try {
            if(conn!=null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if(stat!=null){
                    stat.close();
                    stat=null;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if(rs!=null){
                        rs.close();
                        rs=null;
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }


    }





}

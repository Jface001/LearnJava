package com.test.start;

import java.sql.*;

/**
 * @Author Jface
 * @Date 2021/8/20 11:54
 * @Since version-1.0
 * @Desc 写一个JDBC连接本地MySQL, 查询数据
 */
public class Demo02JDBC {
    public static void main(String[] args) throws SQLException {
        //1.抽取变量
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;


        try {
            //2.创建客户端连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wzry", "root", "123456");

            //3.编译提交SQL语句
            stat = conn.prepareStatement("select * from heros limit 100;");
            rs = stat.executeQuery();

            //4.解析结果集并打印输出
            while (rs.next()) {
                String name = rs.getString(2);
                int hp_max = rs.getInt(3);
                System.out.println(name + "的hp_max是:" + hp_max);
            }

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        } finally {

            //5.关闭结果

            conn.close();
            stat.close();
            rs.close();

        }


    }
}

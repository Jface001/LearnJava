package com.test.demo02_exercise;
import com.test.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author: Jface
 * @Date: 2021/5/24 19:46
 * @Desc:
案例: 演示PreparedStatement接口的CURD操作.
 */
public class Demo01 {

    //查,查询UID为1的用户的信息
    @Test
    public void show01() throws Exception {
        //1.获取连接对象
        Connection conn = JDBCUtils.getConnection();
        //2.设置SQL占位符,获取可以执行SQL语句的对象
        String sql ="select * from users where uid = ? ;";
        PreparedStatement ps = conn.prepareStatement(sql);
        //3.给占位符设置值,执行SQL语句
        ps.setInt(1,4);//第几个参数,设置占位符是啥
        ResultSet rs = ps.executeQuery();//上面已经传入SQL 这里不用再传入
        //4.操作结果集
        while(rs.next()){
            System.out.println(rs.getInt("uid")+", "+rs.getString("uname")+", "+rs.getString("pad"));
        }
        //5.释放资源
        JDBCUtils.release(conn,ps,rs);
    }

    //增
    @Test
    public void show02() throws Exception {
        //1.获取连接对象
        Connection conn = JDBCUtils.getConnection();
        //2.设置SQL占位符,获取执行SQL的对象
        String sql ="insert into users values(null,?,?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        //3.给占位符传值,执行SQL语句
        ps.setString(1,"张若虚");
        ps.setString(2,"pad444");
        int i = ps.executeUpdate();
        //4.操作结果集
        System.out.println(i>0?"添加成功":"添加失败");
        //5.释放资源
        JDBCUtils.release(conn,ps,null);
    }

    //删
    @Test
    public void show03() throws Exception {
        //1.获取连接对象
        Connection conn = JDBCUtils.getConnection();
        //2.设置SQL占位符,获取执行SQL的对象
        String sql ="delete from users where uid = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        //3.给占位符传值,执行SQL语句
        ps.setInt(1,24);
        int i = ps.executeUpdate();
        //4.操作结果集
        System.out.println(i>0?"删除成功":"删除失败");
        //5.释放资源
        JDBCUtils.release(conn,ps,null);
    }

    //改
    @Test
    public void show04() throws Exception {
        //1.获取连接对象
        Connection conn = JDBCUtils.getConnection();
        //2.设置SQL占位符,获取执行SQL的对象
        String sql = "update users set uname =? where uid = ? ;";
        PreparedStatement ps = conn.prepareStatement(sql);
        //3.给占位符传值,执行SQL语句
        ps.setString(1,"韩愈");
        ps.setInt(2,1);
        int i = ps.executeUpdate();
        //4.操作结果集
        System.out.println(i>0?"修改成功":"修改失败");
        //5.释放资源
        JDBCUtils.release(conn,ps,null);

    }

}

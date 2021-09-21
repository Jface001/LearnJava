package com.test.momo_chat.service.impl;


import com.test.momo_chat.entity.Msg;
import com.test.momo_chat.service.ChatMessageService;
import org.apache.phoenix.jdbc.PhoenixDriver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PhoenixChatMessageService
 * @Description TODO JDBC连接Phoenix实现数据查询
 * @Create By     Frank
 */
public class PhoenixChatMessageService implements ChatMessageService {
    private Connection connection;

    public PhoenixChatMessageService() throws ClassNotFoundException, SQLException {
        try {
            //申明驱动类
            Class.forName(PhoenixDriver.class.getName());
//            System.out.println(PhoenixDriver.class.getName());
            //构建连接
            connection = DriverManager.getConnection("jdbc:phoenix:node1,node2,node3:2181");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("加载Phoenix驱动失败!");
        } catch (SQLException e) {
            throw new RuntimeException("获取Phoenix JDBC连接失败!");
        }
    }
    @Override
    public List<Msg> getMessage(String date, String sender, String receiver) throws Exception {
        PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM MOMO_CHAT.MSG T WHERE substr(\"msg_time\", 0, 10) = ? "
                        + "AND T.\"sender_account\" = ? "
                        + "AND T.\"receiver_account\" = ? ");

        ps.setString(1, date);
        ps.setString(2, sender);
        ps.setString(3, receiver);

        ResultSet rs = ps.executeQuery();
        List<Msg> msgList = new ArrayList<>();

        while(rs.next()) {
            Msg msg = new Msg();
            msg.setMsg_time(rs.getString("msg_time"));
            msg.setSender_nickyname(rs.getString("sender_nickyname"));
            msg.setSender_account(rs.getString("sender_account"));
            msg.setSender_sex(rs.getString("sender_sex"));
            msg.setSender_ip(rs.getString("sender_ip"));
            msg.setSender_os(rs.getString("sender_os"));
            msg.setSender_phone_type(rs.getString("sender_phone_type"));
            msg.setSender_network(rs.getString("sender_network"));
            msg.setSender_gps(rs.getString("sender_gps"));
            msg.setReceiver_nickyname(rs.getString("receiver_nickyname"));
            msg.setReceiver_ip(rs.getString("receiver_ip"));
            msg.setReceiver_account(rs.getString("receiver_account"));
            msg.setReceiver_os(rs.getString("receiver_os"));
            msg.setReceiver_phone_type(rs.getString("receiver_phone_type"));
            msg.setReceiver_network(rs.getString("receiver_network"));
            msg.setReceiver_gps(rs.getString("receiver_gps"));
            msg.setReceiver_sex(rs.getString("receiver_sex"));
            msg.setMsg_type(rs.getString("msg_type"));
            msg.setDistance(rs.getString("distance"));

            msgList.add(msg);
        }
        return msgList;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        ChatMessageService chatMessageService = new PhoenixChatMessageService();
        List<Msg> message = chatMessageService.getMessage("2021-07-30", "18402777552", "14780917150");

        for (Msg msg : message) {
            System.out.println(msg);
        }

        chatMessageService.close();
    }
}


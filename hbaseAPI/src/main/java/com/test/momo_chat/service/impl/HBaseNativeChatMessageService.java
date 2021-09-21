package com.test.momo_chat.service.impl;


import com.test.momo_chat.entity.Msg;
import com.test.momo_chat.service.ChatMessageService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HBaseNativeChatMessageService
 * @Description TODO 使用Hbase API来实现基于数据的查询
 * @Create By     Frank
 */
public class HBaseNativeChatMessageService implements ChatMessageService {

    private Connection conn = null;
    private TableName tbName = TableName.valueOf("MOMO_CHAT:MSG");
    private String cf_name = "C1";
    public static String col_msg_time = "msg_time";
    public static String col_sender_nickyname = "sender_nickyname";
    public static String col_sender_account = "sender_account";
    public static String col_sender_sex = "sender_sex";
    public static String col_sender_ip = "sender_ip";
    public static String col_sender_os = "sender_os";
    public static String col_sender_phone_type = "sender_phone_type";
    public static String col_sender_network = "sender_network";
    public static String col_sender_gps = "sender_gps";
    public static String col_receiver_nickyname = "receiver_nickyname";
    public static String col_receiver_ip = "receiver_ip";
    public static String col_receiver_account = "receiver_account";
    public static String col_receiver_os = "receiver_os";
    public static String col_receiver_phone_type = "receiver_phone_type";
    public static String col_receiver_network = "receiver_network";
    public static String col_receiver_gps = "receiver_gps";
    public static String col_receiver_sex = "receiver_sex";
    public static String col_msg_type = "msg_type";
    public static String col_distance = "distance";
    public static String col_message = "message";

    //程序的入口
    public static void main(String[] args) throws Exception {
        //构建当前类的对象
        HBaseNativeChatMessageService messageService = new HBaseNativeChatMessageService();
        //调用方法，查询数据
        List<Msg> message = messageService.getMessage("2021-07-31", "15293589118", "13453974053");
        //迭代打印
        for (Msg msg : message) {
            System.out.println(msg);
        }
        //释放资源
        messageService.close();
    }


    @Override
    public List<Msg> getMessage(String date, String sender, String receiver) throws Exception {
        //1.构建List集合, 用于接收返回值
        List<Msg> list = new ArrayList<>();
        //2.构建连接
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","node1:2181,node2:2181,node3:2181");
        conn =ConnectionFactory.createConnection(conf);
        //3.构建表对象
        Table table = conn.getTable(tbName);
        //4.构建Scan+Filter
        Scan scan = new Scan();
        String startTime =date+" 00:00:00";
        String endTime =date+" 23:59:59";
        SingleColumnValueFilter valueFilter1 = new SingleColumnValueFilter(Bytes.toBytes(cf_name), Bytes.toBytes(col_msg_time), CompareOperator.GREATER_OR_EQUAL, Bytes.toBytes(startTime));
        SingleColumnValueFilter valueFilter2 = new SingleColumnValueFilter(Bytes.toBytes(cf_name), Bytes.toBytes(col_msg_time), CompareOperator.LESS_OR_EQUAL, Bytes.toBytes(endTime));
        SingleColumnValueFilter valueFilter3 = new SingleColumnValueFilter(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_account), CompareOperator.EQUAL, Bytes.toBytes(sender));
        SingleColumnValueFilter valueFilter4 = new SingleColumnValueFilter(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_account), CompareOperator.EQUAL, Bytes.toBytes(receiver));
        FilterList filters = new FilterList();
        filters.addFilter(valueFilter1);
        filters.addFilter(valueFilter2);
        filters.addFilter(valueFilter3);
        filters.addFilter(valueFilter4);
        //5.执行Scan操作
        scan.setFilter(filters);
        ResultScanner scanner = table.getScanner(scan);
        //6.将结果输入到Msg对象
        for (Result result : scanner) {
            Msg msg =new Msg();
            msg.setSender_nickyname(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_sender_nickyname))));
            msg.setSender_account(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_sender_account))));
            msg.setSender_sex(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_sender_sex))));
            msg.setSender_ip(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_sender_ip))));
            msg.setSender_os(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_sender_os))));
            msg.setSender_phone_type(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_sender_phone_type))));
            msg.setSender_network(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_sender_network))));
            msg.setSender_gps(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_sender_gps))));
            msg.setReceiver_nickyname(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_receiver_nickyname))));
            msg.setReceiver_account(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_receiver_account))));
            msg.setReceiver_sex(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_receiver_sex))));
            msg.setReceiver_ip(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_receiver_ip))));
            msg.setReceiver_os(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_receiver_os))));
            msg.setReceiver_phone_type(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_receiver_phone_type))));
            msg.setReceiver_network(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_receiver_network))));
            msg.setReceiver_network(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_receiver_gps))));
            msg.setDistance(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_distance))));
            msg.setMsg_type(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_msg_type))));
            msg.setMessage(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_message))));
            msg.setMsg_time(Bytes.toString(result.getValue(Bytes.toBytes(cf_name),Bytes.toBytes(col_msg_time))));

            //7.Msg对象放入集合
            list.add(msg);
        }



        return list;
    }

    @Override
    public void close() {
        try {
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

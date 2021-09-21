package com.test.momo_chat.tool;
import com.test.momo_chat.entity.Msg;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Gen
 * @Description TODO 用于不断的模拟生成用户聊天的数据，将用户聊天的数据写入Hbase表中
 * @Create By     Frank
 */
public class Gen {

    private static TableName TB_NAME = TableName.valueOf("MOMO_CHAT:MSG");
    private static  SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static String cf_name = "C1";
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
        //todo:1-构建连接
        //构建配置
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","node1:2181,node2:2181,node3:2181");
        //构建连接
        Connection conn = ConnectionFactory.createConnection(conf);
        //todo:2-写入数据
        Table table = conn.getTable(TB_NAME);
        //调用方法，将Excel中模拟生成的数据写入Hbase中
        writeToHbase(table);
        //todo:3-释放连接
        table.close();
        conn.close();
    }

    //写入Hbase表
    private static void writeToHbase(Table table) throws Exception {
        for (int i = 0; i < 300; i++) {
            //1.获取要写入的数据
            Map<String, List<String>> map = ExcelReader.readXlsx("hbaseAPI/datas/测试数据集.xlsx", "陌陌数据");
            Msg msg = ExcelReader.getOneMsg(map);
            //2.构建rowkey
            String rowkey = getRowKey(msg);
            //3.构建put对象
            Put put = new Put(Bytes.toBytes(rowkey));
            //4.添加每一列数据到put对象
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_msg_time), Bytes.toBytes(msg.getMsg_time()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_nickyname), Bytes.toBytes(msg.getSender_nickyname()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_account), Bytes.toBytes(msg.getSender_account()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_sex), Bytes.toBytes(msg.getSender_sex()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_ip), Bytes.toBytes(msg.getSender_ip()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_os), Bytes.toBytes(msg.getSender_os()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_phone_type), Bytes.toBytes(msg.getSender_phone_type()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_network), Bytes.toBytes(msg.getSender_network()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_gps), Bytes.toBytes(msg.getSender_gps()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_nickyname), Bytes.toBytes(msg.getReceiver_nickyname()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_ip), Bytes.toBytes(msg.getReceiver_ip()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_account), Bytes.toBytes(msg.getReceiver_account()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_os), Bytes.toBytes(msg.getReceiver_os()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_phone_type), Bytes.toBytes(msg.getReceiver_phone_type()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_network), Bytes.toBytes(msg.getReceiver_network()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_gps), Bytes.toBytes(msg.getReceiver_gps()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_sex), Bytes.toBytes(msg.getReceiver_sex()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_msg_type), Bytes.toBytes(msg.getMsg_type()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_distance), Bytes.toBytes(msg.getDistance()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_message), Bytes.toBytes(msg.getMessage()));

            //5.执行put对象
            table.put(put);

        }
    }

    //构建rowkey，根据每条数据的内容来生成rowkey:ROWKEY = MD5Hash8位_发件人账号_收件人账号_时间戳
    private static String getRowKey(Msg msg) throws Exception {
        //1.新建一个StringBuilder对象,获取发件人账户
        StringBuilder stringBuilder = new StringBuilder(msg.getSender_account());
        //2.添加收件人账户
        stringBuilder.append("_");
        stringBuilder.append(msg.getReceiver_account());
        stringBuilder.append("_");
        //3.添加时间戳
        long time =input.parse(msg.getMsg_time()).getTime();//获取时间字段, 再格式化, 再转化成毫秒值
        stringBuilder.append(time);
        //4.添加MD5构建的编码,进行编码,并取8位
        String MD5= MD5Hash.getMD5AsHex(Bytes.toBytes(stringBuilder.toString())).substring(0,8);
        String rowkey =MD5+'_'+stringBuilder;
        return rowkey;
    }}

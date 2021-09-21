package com.test.hbase.DDL_DML;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/7/29 10:56
 * @Desc: 使用Hbase Java API 开发DML操作客户端
 */
public class HbaseJavaClientDMLTest {
    //1.构建连接对象
    Connection conn = null;


    @Before
    public void getConnection() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "node1:2181,node2:2181,node3:2181");
        conn = ConnectionFactory.createConnection(conf);
    }


    //2.逻辑代码
    //API中所有的DML操作, 都得封装到Table表对象中,构建获取表对象的方法
    public Table getTable() throws IOException {
        //从表名从获取表对象
        Table table = conn.getTable(TableName.valueOf("test:t1"));
        return table;
    }

    //put 插入,更新, put ns:ntable,rowkey,cf:col,value
    @Test
    public void testPut() throws IOException {
        //2.1获取表对象
        Table table = getTable();
        //2.2获取put对象,需要设置rowkey
        Put put = new Put(Bytes.toBytes("20210201_000"));
        //2.3设置列族,列名,和值
        put.addColumn(Bytes.toBytes("other"), Bytes.toBytes("phone"), Bytes.toBytes("110"));
        table.put(put);
        //2.4释放表对象
        table.close();


    }

    @Test
    //get 获取整个rowkey数据, get ns:ntable,rowkey,cf:col
    public void getTest() throws IOException {
        //2.1获取表对象
        Table table = getTable();
        //2.2获取并设置get对象
        Get get = new Get(Bytes.toBytes("20210201_000"));
        get.addFamily(Bytes.toBytes("other"));
        //2.3获取方法结果集
        Result result = table.get(get);
        //2.4获取结果集细胞集
        Cell[] cells = result.rawCells();
        //2.5通过工具类从细胞集中获取rowkey, 列族,列名, 值
        for (Cell cell : cells) {
            //获取rowkey
            System.out.print(Bytes.toString(CellUtil.cloneRow(cell)) + "\t");
            //获取列组
            System.out.print(Bytes.toString(CellUtil.cloneFamily(cell)) + "\t");
            //获取列名
            System.out.print(Bytes.toString(CellUtil.cloneQualifier(cell)) + "\t");
            //获取值
            System.out.println(Bytes.toString(CellUtil.cloneValue(cell)));
        }
        //2.6释放资源
        table.close();
    }

    @Test
    //delete 删除
    public void deleteText() throws IOException {
        //2.1获取表对象
        Table table =getTable();
        //2.2获取并设置删除对象
        Delete del = new Delete(Bytes.toBytes("20210201_000"));
        del.addFamily(Bytes.toBytes("basic"));
        //2.3调用方法
        table.delete(del);
        //2.4释放资源
        table.close();
    }

    @Test
    // scan 条件查询
    public void scanText() throws IOException {
        //2.1获取表对象
        Table table =getTable();
        Scan scan = new Scan();
        ResultScanner scanner = table.getScanner(scan);
        for (Result result : scanner) {
            for (Cell cell : result.rawCells()) {
                System.out.print(Bytes.toString(CellUtil.cloneRow(cell))+"\t");
                System.out.print(Bytes.toString(CellUtil.cloneFamily(cell))+"\t");
                System.out.print(Bytes.toString(CellUtil.cloneQualifier(cell))+"\t");
                System.out.print(Bytes.toString(CellUtil.cloneValue(cell))+"\t");
                System.out.println(cell.getTimestamp());
            }

        }
        //释放资源
        table.close();


    }

    @After
    //3.释放资源
    public void closeConn() throws IOException {
        conn.close();
    }
}

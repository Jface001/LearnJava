package com.test.hbase.DDL_DML;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/7/29 12:07
 * @Desc: 使用Hbase JavaAPI 实现Scan + Filter的过滤测试
 * 需求1：查询2021年1月和2月的数据：select * from table where time >= 202101 and time <= 202102
 * 需求2：查询2021年的所有数据：select * from table time like '2021%'
 * 需求3：查询所有age = 20的数据：select * from table where age = 20
 * 需求4：查询所有数据的name和age这两列：select name,age from table
 * 需求5：查询所有年age = 20的人的name和age：select name,age from table where age = 20 or name =laoda
 * Rowkey前缀范围过滤：StartROW、STOPROW
 * scan.withStartRow(Bytes.toBytes("202101"));
 * scan.withStopRow(Bytes.toBytes("202103"));
 * <p>
 * Rowkey的前缀等值过滤：PrefixFilter
 * PrefixFilter prefixFilter = new PrefixFilter(Bytes.toBytes("2021"));
 */


public class HbaseJavaClientFilterTest {
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

    @Test
    //2.测试代码逻辑
    public void scanText() throws IOException {
        //2.1获取表对象和scan对象
        Table table = getTable();
        Scan scan = new Scan();
        //需求1: 查询2021年1月和2月的数据, 前缀范围过滤器, 不需要加载
        //scan.withStartRow(Bytes.toBytes("202101"));
        //scan.withStopRow(Bytes.toBytes("202103"));

        //需求2: 查询2021年的所有数据,前缀等值过滤器
        PrefixFilter prefixFilter = new PrefixFilter(Bytes.toBytes("202101"));

        //需求3: 查询所有age = 20的数据, 等值过滤器
        SingleColumnValueFilter valueFilter = new SingleColumnValueFilter
                (Bytes.toBytes("basic"), Bytes.toBytes("age"), CompareOperator.EQUAL, Bytes.toBytes("20"));

        //需求4: 查询所有数据的name和age这两列, 列过滤器
        byte[][] prefixes = {Bytes.toBytes("name"), Bytes.toBytes("age")};
        MultipleColumnPrefixFilter columnPrefixFilter = new MultipleColumnPrefixFilter(prefixes);


        //需求5: 查询所有年age = 20的人的name和age, 多种过滤器组合
        FilterList filterList = new FilterList();
        filterList.addFilter(valueFilter);
        filterList.addFilter(columnPrefixFilter);


        //2.2加载类过滤器, 前缀范围过滤器不需要加载
        scan.setFilter(filterList);
        //2.3执行过滤器,获取结果集
        ResultScanner scanner = table.getScanner(scan);
        //2.4循环遍历结果集, 获取对应结果
        for (Result result : scanner) {
            for (Cell cell : result.rawCells()) {
                System.out.print(Bytes.toString(CellUtil.cloneRow(cell)) + "\t");
                System.out.print(Bytes.toString(CellUtil.cloneFamily(cell)) + "\t");
                System.out.print(Bytes.toString(CellUtil.cloneQualifier(cell)) + "\t");
                System.out.print(Bytes.toString(CellUtil.cloneValue(cell)) + "\t");
                System.out.println(cell.getTimestamp());
            }

        }
    }


    @After
    //3.释放资源
    public void closeConn() throws IOException {
        conn.close();
    }
}

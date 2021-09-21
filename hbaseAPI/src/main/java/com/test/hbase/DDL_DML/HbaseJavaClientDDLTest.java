package com.test.hbase.DDL_DML;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Author: Jface
 * @Date: 2021/7/29 9:58
 * @Desc: 实现Hbase Java API 开发实现DDL操作
 * 1.列举, 创建,删除namespace
 * 2.列举,创建,删除table
 */
public class HbaseJavaClientDDLTest {

    //1.构建连接对象
    Connection conn = null;

    @Before
    public void getConnection() throws IOException {
        //1.1构建配置对象
        Configuration conf = HBaseConfiguration.create();
        //1.2指定服务端地址, 是连接zookeeper地址
        conf.set("hbase.zookeeper.quorum", "node1:2181,node2:2181,node3:2181");
        //3.构建连接对象
        conn = ConnectionFactory.createConnection(conf);
    }

    //2.具体实现代码
    //所有DDL操作, 都必须先获取管理员对象
    public HBaseAdmin getHbaseAdmin() throws IOException {
        HBaseAdmin admin = (HBaseAdmin) conn.getAdmin();
        return admin;
    }

    @Test
    //列举namespace
    public void listNamespaces() throws IOException {
        //2.1管理员对象
        HBaseAdmin admin = getHbaseAdmin();
        //2.2调用方法
        NamespaceDescriptor[] descriptors = admin.listNamespaceDescriptors();
        //2.3遍历namespace
        for (NamespaceDescriptor descriptor : descriptors) {
            System.out.println(descriptor.getName());
        }
        //2.4释放管理员
        admin.close();

    }

    @Test
    //创建namespace
    public void createNamespaces() throws IOException {
        //2.1管理员对象
        HBaseAdmin admin = getHbaseAdmin();
        //2.2构建NS对象
        NamespaceDescriptor descriptor = NamespaceDescriptor.create("hbase01").build();
        //2.3调用方法
        admin.createNamespace(descriptor);
        //2.4释放管理员
        admin.close();
    }

    @Test
    //删除namespace
    public void deleteNamespaces() throws IOException {
        //2.1管理员对象
        HBaseAdmin admin = getHbaseAdmin();
        //2.2调用方法
        admin.deleteNamespace("hbase01");
        //2.3释放管理员
        admin.close();

    }

    @Test
    //列举表
    public void listTable() throws IOException {
        //2.1获取管理员对象
        HBaseAdmin admin = getHbaseAdmin();
        //2.2调用方法
        List<TableDescriptor> descriptors = admin.listTableDescriptors();
        //2.3 遍历table迭代器
        for (TableDescriptor descriptor : descriptors) {
            System.out.println(descriptor.getTableName());
        }
        //2.4释放管理员对象
        admin.close();

    }

    @Test
    //创建表
    public void createTable() throws IOException {
        //2.1获取管理员对象
        HBaseAdmin admin = getHbaseAdmin();
        //2.2创建表名
        TableName name = TableName.valueOf("test:t1");
        //2.3先做判断, 如果表存在, 就删除
        if (admin.tableExists(name)) {
            admin.disableTable(name);
            admin.deleteTable(name);
        }
        //2.4设置列族属性
        ColumnFamilyDescriptor basic = ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes("basic")).setMaxVersions(3).build();
        ColumnFamilyDescriptor other = ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes("other")).setMaxVersions(1).build();
        //2.6获取表对象
        TableDescriptor desc = TableDescriptorBuilder.newBuilder(name).setColumnFamily(basic).setColumnFamily(other).build();
        //2.7调用方法, 创建表
        admin.createTable(desc);
        //2.8释放资源
        admin.close();

    }

    @Test
    //删除表
    public void deleteTable() throws IOException {
        //2.1获取管理员对象
        HBaseAdmin admin = getHbaseAdmin();
        //2.2创建表名对象
        TableName name = TableName.valueOf("test:t1");
        //2.3判断表是否存在
        if (admin.tableExists(name)) {
            //2.4表存在, 先停用,再删除
            admin.disableTable(name);
            admin.deleteTable(name);
        }
        //2.5释放管理员
        admin.close();

    }


    @After
    //3.释放资源
    public void closeConn() throws IOException {
        conn.close();
    }

}

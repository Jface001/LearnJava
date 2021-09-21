package com.test.hbase.coprocessor;

/**
 * @ClassName SyncCoprocessor
 * @Description TODO 自定义协处理器实现：当往原始数据表插入数据时，自动往索引表插入一份
 * @Create By     Frank
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.CoprocessorEnvironment;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessor;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.coprocessor.RegionObserver;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.wal.WALEdit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

public class SyncCoprocessor implements RegionObserver, RegionCoprocessor {
    private static final Logger logger = LoggerFactory.getLogger(SyncCoprocessor.class);
    private RegionCoprocessorEnvironment env = null;



    @Override
    public void start(CoprocessorEnvironment e) throws IOException {
        this.env = (RegionCoprocessorEnvironment) e;
    }



    @Override
    public void stop(CoprocessorEnvironment env) throws IOException {

    }

    /**
     * 加入该方法，否则无法生效
     */
    @Override
    public Optional<RegionObserver> getRegionObserver() {
        return Optional.of(this);
    }




    @Override
    public void prePut(ObserverContext<RegionCoprocessorEnvironment> c,Put put, WALEdit edit, Durability durability) throws IOException {
        logger.info("run ReverseInfoObserver............prePut...........................");
        try {
            //获取连接
            Configuration configuration = HBaseConfiguration.create();
            configuration.set("hbase.zookeeper.quorum", "node1:2181,node2:2181,node3:2181");
            Connection connection = ConnectionFactory.createConnection(configuration);
            //获取了数据表的rowkey
            String rowkey = Bytes.toString(put.getRow());
            String time = rowkey.split("_")[0];
            String userId = rowkey.split("_")[1];
            //将时间和用户id换位，构建新的rowkey
            String newRowkey = userId+"_"+time;
            Put put1 = new Put(Bytes.toBytes(newRowkey));
            //将新的rowkey以及原始数据表的rowkey插入索引表
            put1.addColumn(
                    Bytes.toBytes("info"),
                    Bytes.toBytes("oldRowkey"),
                    Bytes.toBytes(rowkey)
            );
            Table indexTable = connection.getTable(TableName.valueOf("proc2"));
            indexTable.put(put1);
            indexTable.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}


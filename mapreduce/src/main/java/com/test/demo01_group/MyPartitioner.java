package com.test.demo01_group;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @Author: Jface
 * @Date: 2021/6/11 14:27
 * @Desc:
 * 自定义的分区,继承Partitioner类, 用于自定义分区规范
 */
public class MyPartitioner extends Partitioner<OrderBean, NullWritable> {
    /**
     * 用于自定义分区
     * @param orderBean k2的类型,我们按照k2分区
     * @param nullWritable v2
     * @param i 分区的个数
     * @return
     */
    @Override
    public int getPartition(OrderBean orderBean, NullWritable nullWritable, int i) {
        //根据订单号的哈希值分区
        // 如果我们设置为2,任何正数和2取余只有0和1两种结果,
       return  (orderBean.getOrderId().hashCode() & Integer.MAX_VALUE) % i;

    }
}

package com.test.userpart;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;
import java.util.Random;

/**
 * @Author: Jface
 * @Date: 2021/8/3 19:44
 * @Desc: 用于自定义开发分区器, 实现随机分区
 */
public class UserPartitioner implements Partitioner {


    /**
     * 计算分区的逻辑
     * @param topic
     * @param key
     * @param keyBytes
     * @param value
     * @param valueBytes
     * @param cluster
     * @return
     */
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        Random random = new Random();
        Integer part = cluster.partitionCountForTopic(topic);
        int i = random.nextInt(part);
        return i;
    }

    //释放资源
    @Override
    public void close() {

    }
    //获取配置的方法
    @Override
    public void configure(Map<String, ?> configs) {

    }
}

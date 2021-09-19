package com.test.manual;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;


/**
 * @Author: Jface
 * @Date: 2021/8/2 20:12
 * @Desc: 用Java API 实现消费者分区提交事务
 */
public class KafkaConsumerCommitPartitionOffset {
    public static void main(String[] args) {
        //1.构建Kafka消费者连接对象
        //设置配置信息
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "node1:9092,node2:9092,node3:9092");//指定服务端地址
        properties.setProperty("group.id", "test01");//消费者组di
        properties.setProperty("enable.auto.commit", "false");//关注自动提交
        //properties.setProperty("auto.commit.interval.ms","1000");//提交时间间隔
        //设置K和V的反序列化的类
        properties.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer consumer = new KafkaConsumer<>(properties);
        //2.调用方法,获取结果
        //订阅消息
        consumer.subscribe(Arrays.asList("bigdata01"));
        //消费消息
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            //获取当前订阅主题的分区集合
            Set<TopicPartition> partitions = records.partitions();
            //遍历分区集合,根据分区获取数据
            for (TopicPartition partition : partitions) {
                long offset = 0;//循环之外需要使用, 所以抽出来.
                List<ConsumerRecord<String, String>> partRecords = records.records(partition);
                for (ConsumerRecord<String, String> record : partRecords) {
                    String topic = record.topic();
                    int part = record.partition();
                    offset = record.offset();
                    String key = record.key();
                    String value = record.value();
                    System.out.println(topic + "\t" + part + "\t" + offset + "\t" + key + "\t" + value);

                }
                //消费完整个分区消息,提交事务
                //K 你要提交的分区对象,value:这个分区的commit offset
                OffsetAndMetadata offsetAndMetadata = new OffsetAndMetadata(offset + 1);
                Map<Object, Object> offsets = new HashMap<>();
                offsets.put(partition, offsetAndMetadata);
                consumer.commitSync(offsets);
            }


        }

    }
}

package com.test.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @Author: Jface
 * @Date: 2021/8/2 20:12
 * @Desc:
 */
public class KafkaConsumerTestClient {
    public static void main(String[] args) {
        //1.构建Kafka消费者连接对象
        //设置配置信息
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","node1:9092,node2:9092,node3:9092");//指定服务端地址
        properties.setProperty("group.id","test01");//消费者组di
        properties.setProperty("enable.auto.commit","true");//开启自动提交
        properties.setProperty("auto.commit.interval.ms","1000");//提交时间间隔
        //设置K和V的反序列化的类
        properties.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer consumer = new KafkaConsumer<>(properties);
        //2.调用方法,获取结果
        //订阅消息
        consumer.subscribe(Arrays.asList("bigdata01"));
        //消费消息
        while(true){
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                String topic = record.topic();
                int partition = record.partition();
                long offset = record.offset();
                String key = record.key();
                String value = record.value();
                System.out.println(topic+"\t"+partition+"\t"+offset+"\t"+key+"\t"+value);
            }

        }

    }
}

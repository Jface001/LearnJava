package com.test.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Author: Jface
 * @Date: 2021/8/2 20:11
 * @Desc:
 */
public class KafkaProducerTestClient {
    public static void main(String[] args) {
        //1.构建Kafka生产者连接对象
        //设置配置信息
        Properties properties = new Properties();
        properties.put("bootstrap.servers","node1:9092,node2:9092,node3:9092");//设置服务端地址
        properties.put("ack","all");//设置ack参数
        //设置K和V的序列化类
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer producer = new KafkaProducer<>(properties);

        //2.调用方法, 循环写入
        for (int i = 0; i <10000 ; i++) {
        //指定Topic,key,value
        ProducerRecord record01 = new ProducerRecord<>("test001", Integer.toString(i), "kafka"+i);
        //指定Topic,value
        //ProducerRecord record02 = new ProducerRecord<>("test001",  "kafka"+i);
        // 指定Topic,partition,key,value
        //ProducerRecord record03 = new ProducerRecord<>("test001", 0 ,Integer.toString(i),"kafka"+i);
        //执行方法
        producer.send(record01);

        }

        //3.释放资源
        producer.close();

    }
}

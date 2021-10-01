package com.test.demo01_group;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/6/11 20:36
 * @Desc:
 * 自定义Reduce任务,继承Reducer类,用于把k2,v2 --> k3,v3
 * k3 目标格式数据, Text
 * v3 空 NullWritable
 */
public class OrderReduceTask extends Reducer<OrderBean, NullWritable,Text,NullWritable> {
    /**
     * 用于把k2,v2 --> k3,v3
     * @param key  自定义OrderBean类
     * @param values NullWritable,空
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(OrderBean key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        //1.遍历获取k3
//        for (NullWritable value : values) {
//            //2.写出k3,v3
//            context.write(new Text(key.toString()),NullWritable.get());
//        }
        //方式2:直接写出即可
        context.write(new Text(key.toString()),NullWritable.get());
    }
}

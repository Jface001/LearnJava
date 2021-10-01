package com.test.demo01_group;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/6/11 20:28
 * @Desc: 自定义的Map任务, 继承Mapper类, 用于把k1, v1 ---> k2,v2
 * k2 自定义的Order类, v2 NullWritable
 */
public class OrderMapTask extends Mapper<LongWritable, Text, OrderBean, NullWritable> {
    /**
     * 用于把k1,v1 ---> k2,v2
     *
     * @param key     行偏移量
     * @param value   整行数据
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.获取整行数据
        String line = value.toString();
        //2.非空校验
        if (line != null && !"".equals(line)) {
            //3.切割并封装成OrderBean类对象
            String[] arr = line.split("\t");
            OrderBean ob = new OrderBean(arr[0], arr[1], Double.parseDouble(arr[2]));
            //4.写出k2,v2
            context.write(ob, NullWritable.get());
        }

    }
}

package com.test.demo02_flow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/6/12 8:20
 * @Desc: 自定义的Map任务, 继承Mapper类, 负责把k1, v1 --> k2,v2
 * k2,手机号码
 * v2, 上行数据包, 下行数据包, 上行总流量, 下行总流量
 */
public class FlowMapTask extends Mapper<LongWritable, Text, Text, Text> {
    /**
     * 负责把k1,v1 --> k2,v2
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
            //3.切割获取k2,v2
            String[] arr = line.split("\t");
            String s = arr[6] + "\t" + arr[7] + "\t" + arr[8] + "\t" + arr[9];
            //4.写出数据
            context.write(new Text(arr[1]), new Text(s));
        }

    }
}

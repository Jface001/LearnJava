package com.test.demo03_flow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/6/12 20:39
 * @Desc:
 * 自定义的Map任务,继承Mapper类,用于把k1,v1--> k2,v2
 * k2 我们自定义的FlowBean类 v2 手机号码
 */
public class FlowMapTask extends Mapper<LongWritable, Text,FlowBean,Text> {
    /**
     * 用于把k1,v1--> k2,v2
     * @param key 行偏移量
     * @param value 整行数据
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
            //3.切割数据并把数据封装成FlowBean对象
            String[] arr = line.split("\t");
            FlowBean fb = new FlowBean(
                    Integer.parseInt(arr[1]),
                    Integer.parseInt(arr[2]),
                    Integer.parseInt(arr[3]),
                    Integer.parseInt(arr[4])
            );
            //4.写出k2,v2
            context.write(fb,new Text(arr[0]));


        }
    }
}

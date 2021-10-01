package com.test.demo04_friend;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/6/11 18:02
 * @Desc:
 * 自定义的Map任务,继承Mapper类,用于把k1,v1--> k2,v2
 * k1 行偏移量 v1 整行数据, k2 用户 v2 拥有该用户好友的其它用户(单个)
 */
public class FriendMapTask extends Mapper<LongWritable, Text,Text,Text> {
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
        //2.做非空校验
        if (line != null && !"".equals(line)) {
            //3.切割获取k2,v2
            String[] arr = line.split(":");//arr[0]即某个用户,arr[1]这个用户的好友列表
            String[] arr2 = arr[1].split(",");
            for (String s : arr2) {//数组.每个元素即为拥有该用户好友的其它用户
                //5.写出k2,v2
                context.write(new Text(s),new Text(arr[0]));

            }
        }
    }
}

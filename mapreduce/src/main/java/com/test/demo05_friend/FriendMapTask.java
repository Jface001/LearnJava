package com.test.demo05_friend;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Arrays;

/**
 * @Author: Jface
 * @Date: 2021/6/11 18:33
 * @Desc: 自定义的Map任务, 继承Mapper, 用于把k1,v1--> k2,v2
 * k2  拥有该用户好友的其它用户组合(需要排序)  Text
 * v2 用户  Text
 */
public class FriendMapTask extends Mapper<LongWritable, Text, Text, Text> {
    /**
     * 用于把k1,v1--> k2,v2
     *
     * @param key     行偏移量
     * @param value   每行的数据
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
            //3.切割
            String[] arr = line.split(":");
            String[] friend = arr[1].split("-");
            //4.排序
            Arrays.sort(friend);
            //5.嵌套循环获取k2

            for (int i = 0; i < friend.length - 1; i++) {
                String a = friend[i];
                for (int j = i + 1; j < friend.length; j++) {
                    String b = friend[j];
                    String result = a + "-" + b;
                    //6.写出k2,v2
                    context.write(new Text(result), new Text(arr[0]));
                }
            }

        }

    }
}

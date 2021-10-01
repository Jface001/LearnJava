package com.test.demo04_friend;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/6/11 18:15
 * @Desc: 自定义的Reduce任务, 继承Reducer类, 用于把 k2,v2 --> k3,v3
 */
public class FriendReduceTask extends Reducer<Text, Text, Text, NullWritable> {
    /**
     * 用于把 k2,v2 --> k3,v3
     *
     * @param key     用户
     * @param values  拥有这个用户好友的其它用户集合
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //1.遍历集合,并做拼接
        String tmp = "";
        for (Text value : values) {
            String friend = value.toString();
            tmp += value + "-";
        }
        //2.拼接成k3
        String result = key.toString() +":" +tmp;
        //3.写出结果
        context.write(new Text(result), NullWritable.get());
    }
}

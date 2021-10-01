package com.test.demo05_friend;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.TreeSet;

/**
 * @Author: Jface
 * @Date: 2021/6/11 19:37
 * @Desc: 自定义的Reduce任务, 继承Reducer类, 用于把 k2,v2-->k3,v3
 * k3: 目标数据格式,
 * v3: NullWritable
 */
public class FriendReduceTask extends Reducer<Text, Text, Text, NullWritable> {
    /**
     * 用于把 k2,v2-->k3,v3
     *
     * @param key     拥有该用户好友的其它用户组合(需要排序)
     * @param values  用户
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //1.遍历
        TreeSet<String> ts = new TreeSet<>();
        for (Text value : values) {
            //2.排序
            ts.add(value.toString());

        }
        //2.拼接获取k3
        String result = key.toString() + ":" + ts.toString();
        //3.写出k3,v3
        context.write(new Text(result), NullWritable.get());
    }
}

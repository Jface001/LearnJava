package com.test.demo06_inverted;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/6/14 15:53
 * @Desc: 自定义的Reduce任务, 继承Reducer类, 用于把k2, v2--> k3,v3
 * k3 ,我们目标输出的格式
 * v3,空,
 */
public class InvertedReduceTask extends Reducer<Text, IntWritable, Text, NullWritable> {
    /**
     * 用于把k2,v2--> k3,v3
     *
     * @param key     我们拼接的单词格式
     * @param values  单词出现的次数
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        //1.遍历求和
        int count = 0;
        for (IntWritable value : values) {
            count += value.get();
        }
        //2.写出k3,v3
        context.write(new Text(key.toString() +" "+count), NullWritable.get());
    }
}

package com.test.demo06_inverted;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/6/14 15:11
 * @Desc: 自定义的Map任务, 继承Mapper, 用于把k1, v1-->k2,v2
 * k2:单词
 * v2 :单词出现的次数,目前固定为"1".
 */
public class InvertedMapTask extends Mapper<LongWritable, Text, Text, IntWritable> {
    /**
     * 用于把k1,v1-->k2,v2
     *
     * @param key     行偏移量.
     * @param value   整行数据
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
            //3.1 获取当前Task任务的文件切片对象
            FileSplit fs = (FileSplit) context.getInputSplit();//向下转型,获取文件切片对象
            //3.2 通过文件切片对象获取文件名
            String name = fs.getPath().getName();
            //4.切割获取每个单词,即k2
            String[] word = line.split(" ");
            for (String s : word) {
                //5.写出k2,v2
                context.write(new Text(s + "_" + name), new IntWritable(1));
            }
        }
    }
}

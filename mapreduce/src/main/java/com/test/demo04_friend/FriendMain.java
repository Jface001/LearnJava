package com.test.demo04_friend;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * @Author: Jface
 * @Date: 2021/6/11 18:01
 * @Desc: 驱动类, 用于封装核心8步
 */
public class FriendMain {
    public static void main(String[] args) throws Exception {
        //1.创建job任务
        Job job = Job.getInstance(new Configuration());
        //2.封装核心8步
        //2.1 封装输入组件,读取源文件数据,获取k1,v1
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job, new Path("file:///D:\\test\\共同好友\\input\\friends.txt"));
        //2.2 封装自定义的Mapper类,获取k2,v2
        job.setMapperClass(FriendMapTask.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        //2.3 分区,用默认的
        //2.4 排序,用默认的
        //2.5 规约,用默认的
        //2.6 分组,用默认的
        //2.7 封装自定义的Reducer类,获取k3,v3
        job.setReducerClass(FriendReduceTask.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        //2.8 封装输出组件,输出结果到目的地目录,注意父目录必须存在,子目录一定不能存在
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path("file:///D:\\test\\共同好友\\output1"));
        //3.提交job等等任务结果
        //4.退出程序
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}

package com.test.demo01_group;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * @Author: Jface
 * @Date: 2021/6/11 13:19
 * @Desc: 自定义的驱动类, 封装MR核心8步.
 */
public class OrderMain {
    public static void main(String[] args) throws Exception {
        //1.创建job任务
        Job job = Job.getInstance(new Configuration());
        //2.封装核心8步
        //2.1 封装输入组件,读取源文件数据,获取k1,v1
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job, new Path("file:///D:\\test\\自定义groupingComparator\\input\\orders.txt"));
        //2.2 封装自定义的Mapper类,获取k2,v2
        job.setMapperClass(OrderMapTask.class);
        job.setMapOutputKeyClass(OrderBean.class);
        job.setMapOutputValueClass(NullWritable.class);
        //2.3 分区,用自定义的
        job.setPartitionerClass(MyPartitioner.class);
        //2.4 排序,用自定义的,OrderBean已经排序了,不用再弄
        //2.5 规约,用默认的
        //2.6 分组,用自定义的
        job.setGroupingComparatorClass(OrderGroup.class);
        //2.7 封装自定义的Reducer类,获取k3,v3
        job.setReducerClass(OrderReduceTask.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        //2.8 封装输出组件,输出结果到目的地目录,注意父目录必须存在,子目录一定不能存在
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path("file:///D:\\test\\自定义groupingComparator\\output4\\"));
        //细节,记得设置分区个数,即reduce个数
        job.setNumReduceTasks(2);
        //3.提交job等等任务结果
        //4.退出程序
        System.exit(job.waitForCompletion(true) ? 0 : 1);


    }

}

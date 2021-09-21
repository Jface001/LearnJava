package com.test.hbase.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;

/**
 * @ClassName MrMode
 * @Description TODO Mapreduce编程模板
 * @Date 2021/7/31 11:53
 * @Create By     Frank
 */
public class MrMode extends Configured implements Tool {
    /**
     * 负责整个MR程序的创建，配置，提交运行
     * @param args
     * @return
     * @throws Exception
     */
    @Override
    public int run(String[] args) throws Exception {
        //todo:1-构建job
        Job job = Job.getInstance(this.getConf(),"mode");
        job.setJarByClass(MrMode.class);
        //todo:2-配置job
        //input
//        Path inputPath = new Path(args[0]);
//        job.setInputFormatClass(TextInputFormat.class);
//        TextInputFormat.setInputPaths(job,inputPath);
        //map
//        job.setMapperClass(null);
//        job.setMapOutputKeyClass(null);
//        job.setMapOutputValueClass(null);
        Scan scan = new Scan();
        TableMapReduceUtil.initTableMapperJob(
                "test:t1",
                scan,
                MRMapper.class,
                Text.class,
                Text.class,
                job
        );
        //shuffle
        job.setPartitionerClass(null);
        job.setSortComparatorClass(null);
        job.setGroupingComparatorClass(null);
        job.setCombinerClass(null);
        //reduce
//        job.setReducerClass(null);
//        job.setOutputKeyClass(null);
//        job.setOutputValueClass(null);
        job.setNumReduceTasks(1);
        //output
//        Path outputPath = new Path(args[1]);
//        job.setOutputFormatClass(TableOutputFormat.class);
//        TextOutputFormat.setOutputPath(job,outputPath);
        TableMapReduceUtil.initTableReducerJob(
                "mrhbase",
                MRReduce.class,
                job
        );
        //todo:3-提交job
        return job.waitForCompletion(true) ? 0: -1;
    }

    /**
     * 程序入口，调用run方法
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //调用当前类的MrMode的run方法
        Configuration conf = new Configuration();
        int status = ToolRunner.run(conf, new MrMode(), args);
        System.exit(status);
    }

    public static  class MRMapper extends TableMapper<Text,Text> {
        @Override
        protected void map(ImmutableBytesWritable key, Result value, Context context) throws IOException, InterruptedException {
            super.map(key, value, context);
        }
    }

    public class MRReduce extends TableReducer<Text,Text,Text> {
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            //实现reduce
        }

    }

}

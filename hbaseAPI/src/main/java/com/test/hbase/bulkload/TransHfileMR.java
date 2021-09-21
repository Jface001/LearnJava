package com.test.hbase.bulkload;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.HFileOutputFormat2;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;

/**
 * @ClassName TransHfileMR
 * @Description TODO 将一个普通文件的数据转换为一个HFILE的数据文件
 * @Create By     Frank
 */
public class TransHfileMR extends Configured implements Tool {

    public int run(String[] args) throws Exception {
        Job job = Job.getInstance(this.getConf(),"toHfile");
        job.setJarByClass(TransHfileMR.class);
        //input：读取一个普通的 文件
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        // map：将普通文件中的 数据封装成put对象，用于构建HFILE文件
        job.setMapperClass(ToHfileMap.class);
        job.setMapOutputKeyClass(ImmutableBytesWritable.class);
        job.setMapOutputValueClass(Put.class);
        //output：将输出的数据变成HFILE文件
        job.setOutputFormatClass(HFileOutputFormat2.class);
        //将生成的 HFILE文件保存在什么位置
        HFileOutputFormat2.setOutputPath(job,new Path(args[1]));
        //需要以下配置，将put转换为对应的cell
        Connection conn = ConnectionFactory.createConnection(this.getConf());
        //定义最终该HFILE文件要导入哪张表
        Table table = conn.getTable(TableName.valueOf("mrhbase"));
        //获取该表对应的region的位置，用于将文件放入对应的region中
        RegionLocator regionLocator = conn.getRegionLocator(TableName.valueOf("mrhbase"));
        //指定将该HFILE文件最终导入这张表的这个region中
        HFileOutputFormat2.configureIncrementalLoad(job,table,regionLocator);
        //submit
        return job.waitForCompletion(true) ? 0:-1;
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "node1:2181,node2:2181,node3:2181");
        int status = ToolRunner.run(conf,new TransHfileMR(),args);
        System.exit(status);
    }

    public static class ToHfileMap extends Mapper<LongWritable,Text,ImmutableBytesWritable,Put>{
        private ImmutableBytesWritable outputKey = new ImmutableBytesWritable();
        private byte[] family = Bytes.toBytes("info");
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            //将这一行内容进行分割
            String[] items = line.split("\t");
            //将第一列作为rowkey
            String rowkey = items[0];
            this.outputKey.set(rowkey.getBytes());
            Put outputValue = new Put(this.outputKey.get());
            //将名字这一列放入put对象
            String name = items[1];
            outputValue.addColumn(family,"name".getBytes(),name.getBytes());
            context.write(this.outputKey, outputValue);
            //将年龄这一列放入put对象
            String age = items[2];
            outputValue.addColumn(family,"age".getBytes(),age.getBytes());
            context.write(this.outputKey,outputValue);
            //将性别这一列放入put对象
            String sex = items[3];
            outputValue.addColumn(family,"sex".getBytes(),sex.getBytes());
            context.write(this.outputKey,outputValue);
        }
    }

}

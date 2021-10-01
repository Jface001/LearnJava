package com.test.demo02_flow;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


/**
 * @Author: Jface
 * @Date: 2021/6/12 8:27
 * @Desc: 自定义的Reduce任务, 继承Reducer类,负责把k2,v2--> k3,v3
 * k3:手机号码  上行数据包(总和), 下行数据包(总和), 上行总流量(总和), 下行总流量(总和)
 * v3:NullWritable
 */
public class FlowReduceTask extends Reducer<Text, Text, Text, NullWritable> {
    /**
     * 负责把k2,v2--> k3,v3
     *
     * @param key
     * @param values  手机号码
     * @param context 上行数据包, 下行数据包, 上行总流量, 下行总流量
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int upFlow = 0;
        int downFlow = 0;
        int upTotalFlow = 0;
        int downTotalFlow = 0;
        for (Text value : values) {
            String[] arr = value.toString().split("\t");
            upFlow += Integer.parseInt(arr[0]);
            downFlow += Integer.parseInt(arr[1]);
            upTotalFlow += Integer.parseInt(arr[2]);
            downTotalFlow += Integer.parseInt(arr[3]);
        }
        String result = key.toString()+"\t"+upFlow + "\t" + downFlow + "\t" + upTotalFlow + "\t" + downTotalFlow;
        context.write(new Text(result), NullWritable.get());
    }
}

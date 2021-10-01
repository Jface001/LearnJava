package com.test.demo03_flow;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/6/12 20:47
 * @Desc:
 * 自定义的Reduce任务,继承Reducer类,用于把k2,v2-->k3,v3
 */
public class FlowReduceTask extends Reducer<FlowBean,Text,Text, NullWritable> {
    /**
     * 用于把k2,v2-->k3,v3
     * @param key 自定义的FlowBean类
     * @param values 手机号码
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for (Text value : values) {
            String result =value.toString()+"\t"+key.toString();
            context.write(new Text(result),NullWritable.get());
        }
    }
}

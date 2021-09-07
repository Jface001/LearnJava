package com.test.flink.start;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.RichFilterFunction;
import org.apache.flink.api.common.operators.Order;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.GroupReduceOperator;
import org.apache.flink.api.java.operators.SortPartitionOperator;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * @Author: Jface
 * @Date: 2021/9/7 8:25
 * @Desc: 入门案例：使用 Flink DataSet 做  wordcount
 */
public class Wordcount {
    public static void main(String[] args) throws Exception {
        //1.准备环境-env
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //2.准备数据-source
        DataSource<String> inputDataSet = env.readTextFile("learnFlink/datas/wordcount.data");
        //3.处理数据-transformation

        AggregateOperator<Tuple2<String, Integer>> sumDataSet = inputDataSet
                //TODO:清洗过滤
                .filter(new FilterFunction<String>() {
                    @Override
                    public boolean filter(String value) throws Exception {
                        return null != value && value.trim().length() > 0;
                    }
                    //TODO:切割成单个单词
                }).flatMap(new FlatMapFunction<String, String>() {
                    @Override
                    public void flatMap(String value, Collector<String> out) throws Exception {
                        for (String word : value.trim().split("\\s+")) {
                            out.collect(word);
                        }
                    }
                    //TODO:转换成二元组
                }).map(new MapFunction<String, Tuple2<String, Integer>>() {
                    @Override
                    public Tuple2<String, Integer> map(String value) throws Exception {
                        return Tuple2.of(value, 1);
                    }
                    //TODO:分组聚合
                }).groupBy(0).sum(1);
        //TODO: 倒序取前 3,需要设置并行度为 1 才能全局排序
        SortPartitionOperator<Tuple2<String, Integer>> sortDataSet = sumDataSet
                .sortPartition(1, Order.DESCENDING)
                .setParallelism(1);

        //4.输出结果-sink
        sumDataSet.printToErr();
        sortDataSet.print();

        //5.触发执行-execute，没有写出没有不需要触发

    }
}

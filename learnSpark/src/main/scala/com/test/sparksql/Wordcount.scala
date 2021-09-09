package com.test.sparksql

import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}


/**
 * @Author: Jface
 * @Date: 2021/9/9 23:34
 * @Desc: 使用 SparkSQL 读取文本文件做 Wordcount，分别使用 DSL 和 SQL 风格实现
 */
object Wordcount {
  def main(args: Array[String]): Unit = {
    //1.构建上下文对象，并导包
    val spark: SparkSession = SparkSession.builder()
      .appName(this.getClass.getSimpleName.stripSuffix("$"))
      .master("local[*]")
      .config("spark.sql.shuffle.partitions", 4)
      .getOrCreate()

    import spark.implicits._
    //2.读取文本文件，获取 DataSet
    val inputDataSet: Dataset[String] = spark.read.textFile("learnSpark/datas/wordcount.data")
    //测试看看
    //inputDataSet.printSchema()
    //inputDataSet.show()
    //3.使用 DSL风格实现，导包
    import org.apache.spark.sql.functions._
    //3.1 过滤脏数据
    val resultDataset01: Dataset[Row] = inputDataSet.where($"value".isNotNull && length(trim($"value")) > 0)
      //3.2 切割并把 value 行转成列
      .select(explode(split(trim($"value"), "\\s+")).as("word"))
      //3.3 分组并聚合
      .groupBy($"word")
      .agg(count($"word").as("total"))
      //3.4 倒序并只求前5条信息~
      .orderBy($"total".desc)
      .limit(5)

    //resultDataset01.printSchema()
    //resultDataset01.show(10, truncate = false)

    //4.使用 SQL 风格实现
    //4.1 注册临时视图
    //4.2 编写 SQL 并执行
    inputDataSet.createOrReplaceTempView("tmp_view_lines")
    val resultDataSet02: Dataset[Row] = spark.sql(
      """
        |with tmp as
        | (select explode(split(trim(value), "\\s+")) as word
        |from tmp_view_lines
        |where value is not null and length(trim(value)) > 0 )
        |select t.word ,count(1) as total
        |from tmp t
        |group by t.word
        |order by total desc
        |""".stripMargin)
    resultDataSet02.printSchema()
    resultDataSet02.show(5, truncate = false)

    //5.关闭上下文对象
    spark.stop();

  }

}

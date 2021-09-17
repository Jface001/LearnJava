package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/10 10:23
 * @Desc:
 * 8.WorkStudent
  * 关系 继承学生类,实现SpeakEnglish-接口
 * 属性
 * 方法 重写eat 重写study
 */
//定义一个就业班学生类,继承学生类,实现speakEnglish接口
public class WorkStudent extends Student implements SpeakEnglish {
    //1.构造方法,空参和全参
    public WorkStudent() {
    }

    public WorkStudent(String name, int age) {
        super(name, age);
    }

    //2.重写方法
    @Override
    public void eat() {
        System.out.println("吃肠粉加肉和蛋");
    }

    @Override
    public void study() {
        System.out.println("学习JavaEE, Hadoop, Hive, Scala, Flink, Spark等");
    }

    //3.重写接口方法
    @Override
    public void speak_english() {
        System.out.println("学习英语");

    }
}

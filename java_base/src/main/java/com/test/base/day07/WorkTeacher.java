package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/10 10:14
 * @Desc:
 * 6.WorkTeacher
 * 关系 继承老师类,实现SpeakEnglish-接口
 * 属性
 * 方法 重写eat 重写teach
 */
//定义一个就业办老师类,继承老师类,实现speak_english 接口
public class WorkTeacher extends Teacher implements SpeakEnglish {
    //1.构造方法

    public WorkTeacher() {
    }

    public WorkTeacher(String name, int age, double salary) {
        super(name, age, salary);
    }

    //2.重写方法
    @Override
    public void eat() {
        System.out.println("吃兰州拉面");
    }

    @Override
    public void teach() {
        System.out.println("讲JavaEE, Hadoop, Hive, Scala, Flink, Spark等");

    }

    //3.重写接口方法
    @Override
    public void speak_english() {
        System.out.println("学习英语");

    }
}

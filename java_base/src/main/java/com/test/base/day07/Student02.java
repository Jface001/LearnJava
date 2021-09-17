package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/10 16:50
 * @Desc:
4. 已知有学生类, 属性为: 姓名, 语文成绩, 数学成绩, 英语成绩,  他们都要吃饭, 睡觉和学习.
提示用户键盘录入5个学生的信息, 并将这些信息封装成学生对象后, 存储到数组中. 	//数组类型:  Student[] arr = new Student[5];
需求1: 打印所有学生的信息, 格式为:
姓名为张三的同学, 语文成绩为100分, 数学成绩为100分, 英语成绩为100分.
...

需求2: 打印每个学生的总分, 格式为:
姓名为张三的同学, 总分为: 300分
...

需求3: 打印分数最高的学生信息, 格式如下:
分数最高的学生是张三, 总分为300分, 其中语文成绩为100分, 数学成绩为100分, 英语成绩为100分.

 */
//定义一个学生类
public class Student02 {
    //1.属性,全部私有
    private String name;
    private double chinese;
    private double math;
    private double english;

    //2.构造方法,空参和全参
    public Student02() {
    }

    public Student02(String name, double chinese, double math, double english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    //3.getXxx()  setXxx()
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    //4.成员方法,非静态
    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }

    public void study() {
        System.out.println("学习");
    }
}

package com.test.base.day07;

import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/10 16:42
 * @Desc: 4. 已知有学生类, 属性为: 姓名, 语文成绩, 数学成绩, 英语成绩,  他们都要吃饭, 睡觉和学习.
 * 提示用户键盘录入5个学生的信息, 并将这些信息封装成学生对象后, 存储到数组中. 	//数组类型:  Student[] arr = new Student[5];
 * 需求1: 打印所有学生的信息, 格式为:
 * 姓名为张三的同学, 语文成绩为100分, 数学成绩为100分, 英语成绩为100分.
 * ...
 * <p>
 * 需求2: 打印每个学生的总分, 格式为:
 * 姓名为张三的同学, 总分为: 300分
 * ...
 * <p>
 * 需求3: 打印分数最高的学生信息, 格式如下:
 * 分数最高的学生是张三, 总分为300分, 其中语文成绩为100分, 数学成绩为100分, 英语成绩为100分.
 * <p>
 * 分析
 */
public class Demo04 {
    public static void main(String[] args) {
        // 新建对象,通过键盘输入赋值
        Scanner sc = new Scanner(System.in);
        Student02 [] arr = new Student02 [5];

        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + (++i) + "个学生的信息,格式如下 姓名,语文成绩,数学成绩,英语成绩");
//            String a = sc.next();
//            double b = sc.nextDouble();
//            double c = sc.nextDouble();
//            double d = sc.nextDouble();
            arr[i]=new Student02();
            arr[i].setName(sc.next());
            arr[i].setChinese(sc.nextDouble());
            arr[i].setMath(sc.nextDouble());
            arr[i].setEnglish(sc.nextDouble());

        }



        // 打印输出对应的值.
        //


    }
}

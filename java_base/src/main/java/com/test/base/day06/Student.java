package com.test.base.day06;

import com.test.base.day06.Person;

/**
 * @Author: Jface
 * @Date: 2021/5/8 19:30
 * @Desc: 1. 已知有老师和学生都有姓名和年龄, 且都有吃饭的方法, 不同的是: 学生吃牛肉, 老师喝牛肉汤.
 * 学生要学习study(), 老师要讲课teach(), 请用所学, 模拟该知识.
 */
// 定义一个学生类,实体类,也叫JavaBean类,POJO类
// 1.继承Person类
public class Student extends Person {
// 2.构造方法,全参和空参, 牢记空对空, 全参对全参
// 空参
    public Student() {
    }
// 全参
    public Student(String name, int age) {
        super(name, age);
    }


// 3.方法重载,输入方法名即可快速生成
    @Override
    public void eat() {
        System.out.println("吃牛肉");
    }
// 4.设置独有的成员方法
    public void study() {
        System.out.println("好好学习,天天向上");
    }
}

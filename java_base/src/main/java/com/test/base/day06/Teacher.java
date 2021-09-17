package com.test.base.day06;

/**
 * @Author: Jface
 * @Date: 2021/5/8 19:40
 * @Desc: 1. 已知有老师和学生都有姓名和年龄, 且都有吃饭的方法, 不同的是: 学生吃牛肉, 老师喝牛肉汤.
 * 学生要学习study(), 老师要讲课teach(), 请用所学, 模拟该知识.
 */
// 定义一个老师类,也叫实体类,JavaBean类 POJO类
// 1.继承Person类
public class Teacher extends Person {
    // 2.构造方法 牢记:子空参-->父空参 , 子全参-->父全参
    // 空参
    public Teacher(){
    }
    // 全参
    public Teacher(String name,int age){
        super(name,age);
    }

    // 3.方法重写:输入eat就可快速生成
    @Override
    public void eat() {
        System.out.println("喝牛肉汤");
    }
    // 4.设置独有的方法
    public void teach() {
        System.out.println("教书育人,认真备课");
    }
}

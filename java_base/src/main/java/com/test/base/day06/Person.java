package com.test.base.day06;

/**
 * @Author: Jface
 * @Date: 2021/5/8 19:48
 * @Desc: 1. 已知有老师和学生都有姓名和年龄, 且都有吃饭的方法, 不同的是: 学生吃牛肉, 老师喝牛肉汤.
 * 学生要学习study(), 老师要讲课teach(), 请用所学, 模拟该知识.
 * 分析
 * 父类:
 */
// 定义一个人类,也叫实体类 JavaBean类 POJO类
public class Person {
    // 1.成员变量,全部私有
    private String name; // 姓名
    private int age;     // 年龄

    // 2.构造方法,快捷键alt + insert  选择对应内容
    // 空参
    public Person() {
    }
    // 全参
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //3.getXxx() 和 setXxx(),快捷键alt + insert  选择对应内容
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 4.成员方法, 先不写static
    public void eat() {
        System.out.println("吃饭");
    }
}

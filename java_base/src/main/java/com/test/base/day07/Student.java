package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/10 9:56
 * @Desc:
 * 2.学生类
 * 关系 :继承人类,作为子类
 * 属性:
 * 方法:抽象study()
 */
// 定义一个学生类,继承人类
public abstract class Student extends Person02 {
    // 1.构造方法,空参和全参

    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    // 2.抽象方法
    public abstract void study(); // 学习
}

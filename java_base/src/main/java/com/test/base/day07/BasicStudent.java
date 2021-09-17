package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/10 10:19
 * @Desc:
 * 7.BasicStudent
 * 关系 继承学生类
 * 属性
 * 方法 重写eat 重写study
 */
// 定义一个基础班学生类,继承学生类
public class BasicStudent extends Student {
    //1.构造方法,空参 全参
    public BasicStudent() {
    }

    public BasicStudent(String name, int age) {
        super(name, age);
    }

    //2.重写方法
    @Override
    public void eat() {     //重写eat
        System.out.println("吃窝窝头");
    }

    @Override
    public void study() {   //重写study
        System.out.println("学习JavaSE");
    }

}

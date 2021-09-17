package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/10 10:09
 * @Desc:
5.BasicTeacher
关系:继承老师类
属性
方法 重写eat 重写teach
 */
// 定义一个基础班老师类,继承老师类
public class BasicTeacher extends Teacher  {
    //1.构造方法

    public BasicTeacher() {
    }



    public BasicTeacher(String name, int age, double salary) {
        super(name, age, salary);
    }

    //2.重写eat()方法和teach()方法
    @Override
    public void eat() { //重写eat
        System.out.println("吃名厨");
    }

    @Override
    public void teach() { //重写teach
        System.out.println("讲JavaSE");

    }



}

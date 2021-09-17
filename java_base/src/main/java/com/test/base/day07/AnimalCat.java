package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/11 9:29
 * @Desc:
 */
// 定义一个跳高猫类,继承猫, 实现Jump方法
public class AnimalCat extends Cat implements Jump {

    //1.构造方法

    public AnimalCat() {
    }

    public AnimalCat(String name, int age) {
        super(name, age);
    }

    //2.重写接口jump
    @Override
    public void jump() {
        System.out.println("跳高高");
    }
}

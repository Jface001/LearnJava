package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/9 20:40
 * @Desc:
8.BasketballCoach
属性
方法 eat重写 coatch重写 speak重写
 */
// 定义一个类,继承教练类
public class BasketballCoach extends Coach {
    // 构造方法 空参 全参

    public BasketballCoach() {
    }

    public BasketballCoach(String name, int age) {
        super(name, age);
    }

    //重写方法
    @Override
    public void eat() {
        System.out.println("吃开封菜");
    }

    @Override
    public void teach() {
        System.out.println("如何运球和投篮");
    }

}

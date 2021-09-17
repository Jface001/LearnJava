package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/9 20:36
 * @Desc: 7.PingPangCoach
 * 属性
 * 方法 eat重写 coatch重写 speak重写
 */
//定义一个类,继承教练类,实现Speak接口
public class PingPangCoach extends Coach implements Speak {
    // 构造方法 空参和全参

    public PingPangCoach() {
    }

    public PingPangCoach(String name, int age) {
        super(name, age);
    }

    //重写方法
    @Override
    public void eat() {
        System.out.println("吃金拱门");

    }

    //重写接口方法
    @Override
    public void teach() {
        System.out.println("教如何发球");

    }

    @Override
    public void speak() {
        System.out.println("学习英语");

    }

}

package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/9 20:30
 * @Desc: 2. 已知有乒乓球运动员(PingPangPlayer)和篮球运动员(BasketballPlayer), 乒乓球教练(PingPangCoach)和篮球教练(BasketballCoach).
 * 他们都有姓名和年龄, 都要吃饭, 但是吃的东西不同.
 * 乒乓球教练教如何发球, 篮球教练教如何运球和投篮.
 * 乒乓球运动员学习如何发球, 篮球运动员学习如何运球和投篮.
 * 为了出国交流, 跟乒乓球相关的人员都需要学习英语.
 * 请用所学, 模拟该知识.
 * 分析
 * 方法 eat重写 study重写 speak重写
 * 6.BasketballPlayer
 * 属性
 * 方法 eat重写 study重写 speak重写
 */
//定义一个篮球运动类 继承运动员类.
public class BasketballPlayer extends Player {
    //构造方法, 空参 全参

    public BasketballPlayer() {
    }

    public BasketballPlayer(String name, int age) {
        super(name, age);
    }

    //重写方法
    @Override
    public void eat() {
        System.out.println("吃阿尔卑斯");
    }

    @Override
    public void study() {
        System.out.println("学习如何运球和投篮");
    }

}

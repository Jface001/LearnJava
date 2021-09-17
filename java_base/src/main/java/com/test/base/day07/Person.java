package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/9 20:12
 * @Desc: 2. 已知有乒乓球运动员(PingPangPlayer)和篮球运动员(BasketballPlayer), 乒乓球教练(PingPangCoach)和篮球教练(BasketballCoach).
 * 他们都有姓名和年龄, 都要吃饭, 但是吃的东西不同.
 * 乒乓球教练教如何发球, 篮球教练教如何运球和投篮.
 * 乒乓球运动员学习如何发球, 篮球运动员学习如何运球和投篮.
 * 为了出国交流, 跟乒乓球相关的人员都需要学习英语.
 * 请用所学, 模拟该知识.
 * 分析
 * 1.爷爷类
 * 属性 name age
 * 方法 eat
 * 2.Player父类
 */
// 定义一个人类,也叫JavaBean类 POJO类
public abstract class Person {
    //1.属性 全部私有化
    private String name;
    private int age;
    //构造方法,空参和全参

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //getXxx() setXxx()

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

    //抽象方法
    public abstract void eat();
}

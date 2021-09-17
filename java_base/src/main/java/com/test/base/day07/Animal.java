package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/9 18:20
 * @Desc: 1. 已知有猫类和狗类, 它们都有姓名和年龄, 都要吃饭, 不同的是猫吃鱼, 狗吃肉.
 * 它们都有跑步的功能, 而且仅仅是跑步, 并无任何区别.
 * 猫独有自己的功能: 抓老鼠catchMouse(), 狗独有自己的功能: 看家lookHome()
 * 部分的猫和狗经过马戏团的训练后, 学会了跳高jump(), 请用所学, 模拟该知识.
 * <p>
 * 分析如下
 * 父类 Animal
 * 属性: name age
 * 行为: run  eat()
 * <p>
 * 子类 cat
 * 属性: 继承Animal
 * 行为:  run(继承) eat(吃鱼)   catchMouse(独有)
 * <p>
 * 子类dog
 * 属性: 继承Animal
 * 行为: run(继承) eat(吃肉)   lookHome(独有)
 * <p>
 * 接口
 * jump()
 */
// 定义一个动物类,也叫JavaBean类, POJO类
public abstract class Animal {
    //1.属性 全部私有
    private String name;
    private int age;
    //2.构造方法, 全参 空参

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //3. getXxx()  setXxx()

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

    //4.非静态方法 ,不写static
    public void run() {
        System.out.println("跑路");
    }

    //5.抽象方法(有抽象方法, 必须是抽象类)
    public abstract void eat(); // 吃饭


}

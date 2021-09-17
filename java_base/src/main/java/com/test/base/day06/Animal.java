package com.test.base.day06;

/**
 * @Author: Jface
 * @Date: 2021/5/8 21:34
 * @Desc: 3. 已知猫和狗都有姓名和年龄, 且都有吃饭的方法, 不同的吃: 猫吃鱼, 狗吃肉. 它们都有跑步的方法, 而且仅仅是跑步.
 * 猫独有自己的抓老鼠(catchMouse)的功能, 狗独有自己的看门(lookHome)的功能. 请用所学, 模拟该知识.*
 * 分析
 * 1.需要构建3个类,父类为Animal, 2个子类 Cat和Dog
 * 2.父类共同的成员
 * 属性: name  age
 * 行为: eat run
 * 3.独有的方法
 * Cat: eat(吃鱼)  catchMouse
 * Dog: eat(吃肉) lookHome
 */
// 1.定义一个Animal类,即 实体类 POJO类  JavaBean类
public class Animal {
    // 2.成员属性,全部私有
    private String name;
    private int age;

    // 3.构造方法,空参和全参, 快捷键 Alt + insert
// 空参
    public Animal() {
    }

    // 全参
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

// 4.getXxx() 和 setXxx()

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

    // 5.成员方法,先不写static
    public void eat() {
        System.out.println("吃饭");
    }
    public void run(){
        System.out.println("跑步");
    }


}

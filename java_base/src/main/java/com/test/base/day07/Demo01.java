package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/9 18:13
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
public class Demo01 {
    public static void main(String[] args) {
        //1.测试猫全参
        // 新建对象并赋值
        Cat c1 = new Cat("李白", 2);
        System.out.println(c1.getName() + ".." + c1.getAge());
        c1.eat();
        c1.run();
        c1.catchMouse();
        System.out.println("-------------");
        //2.接口多态
        Jump j = new AnimalCat();
        j.jump();
        System.out.println("-------------");
        //3.测试猫多态
        Animal a1 = new Cat("杜甫", 3);
        System.out.println(a1.getName() + ".." + a1.getAge());
        // 向下转型测试
        Cat c2 = (Cat) a1;
        c2.catchMouse();//抓老鼠
        System.out.println("-------------");

    }
}

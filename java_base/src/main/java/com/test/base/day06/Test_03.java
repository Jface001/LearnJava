package com.test.base.day06;

/**
 * @Author: Jface
 * @Date: 2021/5/8 21:53
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
public class Test_03 {
    public static void main(String[] args) {
        //1.测试空参
        // 测试猫猫空参
        Cat c1 = new Cat();
        c1.setName("李白");
        c1.setAge(2);
        System.out.println(c1.getName() + "已经" + c1.getAge() + "岁");
        // 测试狗狗空参
        Dog d1 = new Dog();
        d1.setName("杜甫");
        d1.setAge(3);
        System.out.println(d1.getName() + "已经" + d1.getAge() + "岁");
        System.out.println("--------------");
        //2.测试全参
        // 猫猫全参
        Cat c2 = new Cat("李白", 2);
        System.out.println(c2.getName() + "已经" + c2.getAge() + "岁");
        // 狗狗全参
        Dog d2 = new Dog("杜甫", 3);
        System.out.println("--------------");
        System.out.println(d2.getName() + "已经" + d2.getAge() + "岁");
        //3.多态测试
        //4.测试方法重载
        c1.eat();//吃鱼
        d1.eat();//吃肉
        System.out.println("--------------");
        //5.测试独有方法
        c1.catchMouse();//抓老鼠
        d1.lookHome();// 看门
        //6.测试共有方法
        c1.run();// 跑步
        d1.run();// 跑步

        System.out.println("--------------");
        //.7 补充: 多态测试
        Animal a1 = new Cat("猪皮", 4);
        System.out.println(a1.getName() + ".." + a1.getAge());
        a1.eat();
        a1.run();
        Cat c3 = (Cat) a1;// 向下转型
        ((Cat) a1).catchMouse();


    }
}

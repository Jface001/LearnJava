package com.test.base.day06;


/**
 * @Author: Jface
 * @Date: 2021/5/8 20:02
 * @Desc: 1. 已知有老师和学生都有姓名和年龄, 且都有吃饭的方法, 不同的是: 学生吃牛肉, 老师喝牛肉汤.
 * * 学生要学习study(), 老师要讲课teach(), 请用所学, 模拟该知识.
 */
public class Test_01 {
    public static void main(String[] args) {
        // 1.测试空参
        // 1.1 学生类测试空参
        Student s1 = new Student();
        s1.setName("刘亦菲");
        s1.setAge(33);
        System.out.println(s1.getName() + "..." + s1.getAge());
        // 1.2 老师类测试空参
        Teacher t1 = new Teacher();
        t1.setAge(31);
        t1.setName("高圆圆");
        System.out.println(t1.getName() + "..." + t1.getAge());
        System.out.println("--------------");
        // 2.测试全参
        //2.1学生类全参测试
        Student s2 = new Student("刘亦菲", 33);
        System.out.println(s2.getName() + "..." + s2.getAge());
        //2.2 老师类全参测试
        Teacher t2 = new Teacher("高圆圆", 31);
        System.out.println(t2.getName() + "..." + t2.getAge());
        System.out.println("--------------");
        // 3.测试方法重载
        s1.eat();// 吃牛肉
        t1.eat();// 喝牛肉汤
        // 4.测试独有方法
        s1.study();// 好好学习,天天向上
        t1.teach();// 教书育人,认真备课

        // 5.补充多态测试
        Person p = new Teacher("张三丰", 108);
        p.eat();
//        p.study();// 不能调用子类特有的方法
        Teacher s3 = (Teacher) p;// 向下转型
        s3.teach();
        System.out.println(p.getName() + ".." + p.getAge());
        System.out.println("----------------");


    }
}

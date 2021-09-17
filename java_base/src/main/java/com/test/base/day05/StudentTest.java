package com.test.base.day05;

/**
 * @Author: Jface
 * @Date: 2021/5/7 20:18
 * @Desc: 3. 定义学生类Student, 属性和行为如下, 并在测试类StudentTest中, 创建学生类的对象, 然后访问类中的成员.
 * 属性:
 * 姓名: name
 * 年龄: age
 * 学习内容: content
 * 行为:
 * 吃饭: eat()
 * 学习: study()
 * 控制台输出结果格式如下: 	//属性值可以自定义, 但是必须是下述的格式.
 * 年龄为23的小奇同学正在吃饭....
 * 年龄为23的小奇同学正在专心致志的听着面向对象的知识....("面向对象"代表学生学习的内容)
 */

public class StudentTest {
    public static void main(String[] args) {
//        1.新建Student类的对象
        Student s = new Student();
//        2.给成员变量赋值
        s.setName("小奇同学");
        s.setAge(23);
        s.setContent("面向对象");
//        3.按照要求打印输出对应语句
        System.out.print("年纪为" + s.getAge() + "的" + s.getName());//拼凑语句,所以不换行
        s.eat("正在吃饭...");
        System.out.println();//手动换行~
        System.out.print("年纪为" + s.getAge() + "的" + s.getName());
        s.study("正在专心致志的听着");
        System.out.print(s.getContent());
        System.out.println("的知识...");


    }
}

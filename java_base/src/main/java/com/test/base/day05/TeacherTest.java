package com.test.base.day05;

/**
 * @Author: Jface
 * @Date: 2021/5/7 19:49
 * @Desc: 2. 定义老师类Teacher, 属性和行为如下, 并在测试类TeacherTest中, 创建老师类的对象, 然后访问类中的成员.
 * 属性:
 * 姓名: name
 * 年龄: age
 * 讲课内容: content
 * 行为:
 * 吃饭: eat()
 * 讲课: teach()
 * /*
 * 控制台输出结果格式如下:   //属性值可以自定义, 但是必须是下述的格式.
 * 年龄为18的刘立老师正在吃饭....
 * 年龄为18的刘立老师正在亢奋的讲着Java基础中面向对象的知识........("Java基础中面向对象"代表老师讲课的内容)
 */
public class TeacherTest {
    public static void main(String[] args) {
//        1.新建Teacher类的对象
        Teacher t = new Teacher();
//        2.打印输出默认值;
        System.out.println(t.getName());// int类型默认值是0
        System.out.println(t.getAge());// String类型默认值是 null
        System.out.println(t.getContent());// String类型默认值是 null
        System.out.println("-------------");
//        3.给成员属性赋值
        t.setAge(18);
        t.setName("刘立老师");
        t.setContent("Java基础中面向对象");
//        4.按照要求打印输出对应语句
        System.out.print("年纪为" + t.getAge() + "的" + t.getName());//和下方引用方法不换行即可
        t.eat("正在吃饭......");// 调用方法
        System.out.println();// 换行
        System.out.print("年纪为" + t.getAge() + "的" + t.getName());
        t.teach("正在亢奋的讲着");//调用方法
        System.out.println(t.getContent() + "的知识");


    }
}

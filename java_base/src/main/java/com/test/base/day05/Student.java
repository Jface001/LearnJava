package com.test.base.day05;

/**
 * @Author: Jface
 * @Date: 2021/5/7 20:06
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
// 定义一个学生类,即实体类 JavaBean类, POJO类
public class Student {
    // 1.设置属性即成员变量并且私有化,加上private
    private String name;
    private int age;
    private String content;

    // 2.构造方法
    // 2.1空参
    // 2.2全参

    //3.设置成员变量访问公共入口, 即getXxx() 和 setXxx()
    //3.1设置姓名
    public String getName() {
        return name;
    }

    public void setName(String a) {
        name = a;
    }

    //3.2设置年纪
    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        age = a;
    }

    //3.3 设置学习内容
    public String getContent() {
        return content;
    }
    public void setContent(String a) {
        content = a;
    }

    // 4.设置成员方法,不用写static
    // 4.1设置eat()方法
    public void eat(String a) {
        System.out.print(a);// 输入语句需要拼凑,所以不换行,需要再输入换行即可
    }
    // 4.2 设置study()方法
    public void study(String a) {
        System.out.print(a);
    }

}

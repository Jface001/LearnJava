package com.test.base.day05;

/**
 * @Author: Jface
 * @Date: 2021/5/7 19:37
 * @Desc: 2. 定义老师类Teacher, 属性和行为如下, 并在测试类TeacherTest中, 创建老师类的对象, 然后访问类中的成员.
 * 属性:
 * 姓名: name
 * 年龄: age
 * 讲课内容: content
 * 行为:
 * 吃饭: eat()
 * 讲课: teach()
 * 控制台输出结果格式如下:   //属性值可以自定义, 但是必须是下述的格式.
 * 年龄为18的刘立老师正在吃饭....
 * 年龄为18的刘立老师正在亢奋的讲着Java基础中面向对象的知识........("Java基础中面向对象"代表老师讲课的内容)
 */

public class Teacher {
//    定义一个教师类,也叫实体类,JavaBean类,POJO类
    // 1设置属性:成员变量 加上private 私有化
    private String name;
    private int age;
    private String content;
    // 2.构造方法,空参和全参,快捷键 Alt + insert
    // 空参
    public Teacher() {
    }
    // 全参
    public Teacher(String name, int age, String content) {
        this.name = name;
        this.age = age;
        this.content = content;
    }

    // 3 设置getXxx() 和 sexXxx()
    public String getName() {//获取姓名
        return name;
    }

    public void setName(String a) { //设置姓名
        name = a;
    }

    public int getAge() { //获取年龄
        return age;
    }

    public void setAge(int a) { //设置年龄
        age = a;
    }

    public String getContent() { //获取内容
        return content;
    }

    public void setContent(String a) { //设置内容
        content = a;
    }

    //   4设置成员方法,先不加 static
    public void eat(String a) {
        System.out.print(a);
    }

    public void teach(String content) {
        System.out.print(content);
    }
}

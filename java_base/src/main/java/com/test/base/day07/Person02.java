package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/10 9:53
 * @Desc: 3. 已知学校有基础班老师(BasicTeacher)和就业班老师(WorkTeacher), 基础班学生(BasicStudent)和就业班学生(WorkStudent).
 * 他们都有姓名, 年龄, 都要吃饭, 不同的是学生吃牛肉, 老师喝牛肉汤.
 * 老师有自己的额外属性: 工资(salary), 且老师需要讲课(基础班老师讲JavaSE, 就业班老师讲JavaEE, Hadoop, Hive, Scala, Flink, Spark等).
 * 基础班学生学习JavaSE, 就业班学生学习JavaEE, Hadoop, Hive, Scala, Flink, Spark等.
 * 为了扩大就业市场, 跟就业班相关的人员都需要学习英语.
 * 请用所学, 模拟该知识.
 * 分析
 * 1.人类
 * 关系:作为父类
 * 属性: name age
 * 方法: 抽象eat()
 */
// 定义一个人类,作为父类
public abstract class Person02 {
    //1.属性 全部私有
    private String name;
    private int age;
    //2.构造方法,空参和全参

    public Person02() {
    }

    public Person02(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //3.getXxx()  setXxx()

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

    //4.行为,非静态方法,不写static
    public abstract void eat();
}

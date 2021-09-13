package com.test.pojo;

/**
 * @Author: Jface
 * @Date: 2021/5/21 20:48
 * @Desc:
 */
//定义一个学生类
public class Student {
    //1.成员属性,私有的和公开的
    //私有的
    private String name;
    //公开的
    public int age;

    //2.构造方法,空参 全参 带参
    //空参
    public Student() {
    }

    //私有的,带参
    private Student(String name) {
        this.name = name;

    }

    //全参
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //3.getXxx() 和 setXxx()

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

    //4.成员方法, 重写方法
    //重写方法


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //公共的,无参无返回值
    public void eat() {
        System.out.println("我爱吃冰淇淋!!");
    }

    //私有带参有返回值方法
    private int getSum(int a, int b) {
        return a + b;
    }
}

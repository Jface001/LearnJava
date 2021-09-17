package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/10 10:01
 * @Desc:
 * 3.老师类
 * 关系: 继承人类,作为紫薇路
 * 属性:salary
 * 方法:抽象teach()
 */
// 定义一个老师类,继承人类,加上独有属性和抽象方法
public abstract class Teacher extends Person02 {
    //1.加上独有属性,全部私有
    private double salary;

    //2.构造方法,空参和全参
    public Teacher() {
    }

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    //3.getXxx() setXxx(),独有属性需要再额外加上
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //3.抽象方法
    public abstract void teach();// 教课

}

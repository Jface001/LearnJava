package com.test.base.day06;


/**
 * @Author: Jface
 * @Date: 2021/5/8 21:17
 * @Desc: 2. 定义项目经理类Manager和程序员类Coder, 他们都有姓名, 工号, 工资属性. 项目经理额外有奖金(bonus)属性.
 * 他们都要吃饭, 睡觉, 工作. 不同的是, 工作内容不同. 请用所学, 模拟该知识.
 * Employee:  员工类
 * 属性:
 * 姓名, 工号, 工资
 * 行为:
 * eat(), sleep(), work()
 */
public class Test_02 {
    public static void main(String[] args) {
        // 1.测试空参
        // 项目经理空参
        Manager m1 = new Manager();
        m1.setName("郭靖");
        m1.setId("gb_001");
        m1.setSalary(10000);
        m1.setBonus(5000);
        System.out.println(m1.getName() + " 工号:" + m1.getId() + " 月薪:" + m1.getSalary() + " 奖金:" + m1.getBonus());
        System.out.println("------------------");
        // 程序员空参测试
        Coder c1 = new Coder();
        c1.setName("黄蓉");
        c1.setId("gb_002");
        c1.setSalary(15000);
        System.out.println(c1.getName() + " 工号:" + c1.getId() + " 月薪:" + c1.getSalary());
        System.out.println("------------------");
        // 2.测试全参
        // 项目经理全参测试
        Manager m2 = new Manager("郭靖", "gb_001", 10000, 5000);
        System.out.println(m2.getName() + " 工号:" + m2.getId() + " 月薪:" + m2.getSalary() + " 奖金:" + m2.getBonus());
        // 程序员全参测试
        Coder c2 = new Coder("黄蓉", "gb_002", 15000);
        System.out.println(c2.getName() + " 工号:" + c2.getId() + " 月薪:" + c2.getSalary());
        System.out.println("------------------");
        // 3.测试方法重载
        // 项目经理方法调用
        m1.eat();
        m1.sleep();
        m1.work();//项目管理工作
        // 程序员方法调用
        c1.eat();
        c1.sleep();
        c1.work();// 写代码

        // 4.补充多态测试
        Employee e1 = new Coder("黄蓉", "gb_002", 15000);
        System.out.println(e1.getName() + " 工号:" + e1.getId() + " 月薪:" + e1.getSalary());
        System.out.println("------------------");
        // 调用父类方法 和调用子类特有方法
        e1.work();
    }
}

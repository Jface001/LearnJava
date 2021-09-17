package com.test.base.day06;

import com.test.base.day06.Employee;

/**
 * @Author: Jface
 * @Date: 2021/5/8 21:13
 * @Desc: 2. 定义项目经理类Manager和程序员类Coder, 他们都有姓名, 工号, 工资属性. 项目经理额外有奖金(bonus)属性.
 * 他们都要吃饭, 睡觉, 工作. 不同的是, 工作内容不同. 请用所学, 模拟该知识.
 * Employee:  员工类
 * 属性:
 * 姓名, 工号, 工资
 * 行为:
 * eat(), sleep(), work()
 */
// 1.继承Employee父类,
public class Coder extends Employee {
    // 2.构造方法,空参和全参
// 空参
    public Coder() {

    }

    // 全参
    public Coder(String name, String id, double salary) {
        super(name, id, salary);
    }

    // 3.方法重载,修改成独有成员方法
    @Override
    public void work() {
        System.out.println("写代码");
    }
}

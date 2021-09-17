package com.test.base.day06;

import com.test.base.day06.Employee;

/**
 * @Author: Jface
 * @Date: 2021/5/8 21:07
 * @Desc: 2. 定义项目经理类Manager和程序员类Coder, 他们都有姓名, 工号, 工资属性. 项目经理额外有奖金(bonus)属性.
 * *    他们都要吃饭, 睡觉, 工作. 不同的是, 工作内容不同. 请用所学, 模拟该知识.
 * * 	Employee:  员工类
 * * 		属性:
 * * 			姓名, 工号, 工资
 * * 		行为:
 * * 			eat(), sleep(), work()
 */
// 1.继承Employee父类
public class Manager extends Employee {
    // 2.设置独有成员属性
    private double bonus;// 奖金

    // 3.构造方法
// 空参
    public Manager() {
    }

    // 全参,注意合并独有成员属性纳入全参构造方法
    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus; // 子类自己调用赋值
    }
// 4. getXxx() 和 getXxx()

    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

// 5.方法重载,加上独有成员方法

    @Override
    public void work() {
        System.out.println("项目管理工作");
    }
}

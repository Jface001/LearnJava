package com.test.base.day05;

/**
 * @Author: Jface
 * @Date: 2021/5/7 20:48
 * @Desc: 4. 定义项目经理类Manager, 属性和行为如下, 并在测试类ManagerTest中, 创建项目经理类的对象, 然后访问类中的成员.
 * 属性：
 * 姓名: name
 * 工号: id
 * 工资: salary
 * 奖金: bonus
 * 行为：
 * 工作: work()
 * 要求: 在测试类的main方法中, 要分别通过setXxx()和构造方法的方式, 给对象的属性赋值.
 * 控制台输出结果格式如下: 	//属性值可以自定义, 但是必须是下述的格式.
 * set方法: 工号为123, 基本工资为15000, 奖金为6000的项目经理张三正在努力的做着管理工作,分配任务,检查员工提交上来的代码.....
 * 构造方法:工号为666, 基本工资为20000, 奖金为1000的项目经理王五正在努力的做着管理工作,分配任务,检查员工提交上来的代码.....
 */

public class ManagerTest {
    public static void main(String[] args) {
//        1.新建Manager类的方法
        Manager m = new Manager();
//        2.给成员属性赋值
        m.setName("项目经理张三");
        m.setId(123);
        m.setSalary(15000);
        m.setBonus(6000);
//        3.按照要求输出语句,注意分行问题.
        System.out.print("工号为" + m.getId() + ",基本工资为" + m.getSalary() + ",奖金为" + m.getBonus() + "的" + m.getName());
        m.work("正在努力的做着管理工作,分配任务,检查员工提交上来的代码.....");


    }
}

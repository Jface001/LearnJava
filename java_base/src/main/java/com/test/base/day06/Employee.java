package com.test.base.day06;

/**
 * @Author: Jface
 * @Date: 2021/5/8 20:57
 * @Desc:
 * 2. 定义项目经理类Manager和程序员类Coder, 他们都有姓名, 工号, 工资属性. 项目经理额外有奖金(bonus)属性.
 *    他们都要吃饭, 睡觉, 工作. 不同的是, 工作内容不同. 请用所学, 模拟该知识.
 * 	Employee:  员工类
 * 		属性:
 * 			姓名, 工号, 工资
 * 		行为:
 * 			eat(), sleep(), work()
 *
 */
// 定义员工类,又叫实体类 JavaBean类,POJO类.
public class Employee {
    // 1.成员属性, 全部私有
    private String name;
    private String id;
    private double salary;

    // 2.构造方法,全参和空参,快捷键 alt + insert
    // 空参
    public Employee() {
    }
    // 全参
    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    //3.setXxx() 和 getXxx(),快捷键 alt + insert
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // 4.成员方法,先不写static
    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
    public void work(){
        System.out.println("工作");
    }

}

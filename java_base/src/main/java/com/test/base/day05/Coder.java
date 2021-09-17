package com.test.base.day05;

/**
 * @Author: Jface
 * @Date: 2021/5/7 20:57
 * @Desc:
 * 5. 定义程序员类Coder, 属性和行为如下, 并在测试类CoderTest中, 创建程序员类的对象, 然后访问类中的成员.
 * 	属性：
 * 		姓名: name
 * 		工号: id
 * 		工资: salary
 * 	行为：
 * 		工作: work()
 * 	要求: 在测试类的main方法中, 要分别通过setXxx()和构造方法的方式, 给对象的属性赋值.
 *
 * 	控制台输出结果格式如下: 	//属性值可以自定义, 但是必须是下述的格式.
 * 		set方法: 工号为222, 基本工资为10000的程序员张三正在努力的写着代码.....
 * 		构造方法:工号为333, 基本工资为15000的程序员王五正在努力的写着代码.....

 */
public class Coder {
    //    1.设置成员属性并私有化
    private String name;
    private int id;
    private double salary;

    //    2.设置成员属性访问入口
//    name的访问入口
    public String getName() {//获取name下同
        return name;
    }

    public void setName(String a) {// 设置name下同
        name = a;
    }

    public int getId() {
        return id;
    }

    public void setId(int a) {
        id = a;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double a) {
        salary = a;
    }

    //    3.设置成员方法,不用写static

    /**
     * 用于描述正在进行的工作,输出打印工作内容
     *
     * @param a 代表正在做的工作内容
     */
    public void work(String a) {
        System.out.print(a);
    }
}
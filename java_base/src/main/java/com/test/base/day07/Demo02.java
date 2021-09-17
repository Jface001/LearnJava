package com.test.base.day07;

/**
 * @Author: Jface
 * @Date: 2021/5/9 19:59
 * @Desc: 2. 已知有乒乓球运动员(PingPangPlayer)和篮球运动员(BasketballPlayer), 乒乓球教练(PingPangCoach)和篮球教练(BasketballCoach).
 * 他们都有姓名和年龄, 都要吃饭, 但是吃的东西不同.
 * 乒乓球教练教如何发球, 篮球教练教如何运球和投篮.
 * 乒乓球运动员学习如何发球, 篮球运动员学习如何运球和投篮.
 * 为了出国交流, 跟乒乓球相关的人员都需要学习英语.
 * 请用所学, 模拟该知识.
 * 分析
 * 1.爷爷类
 * 属性 name age
 * 方法 eat
 * 2.Player父类
 * 属性
 * 方法 抽象study
 * 3.Coatch父类
 * 属性
 * 方法 抽象teach
 * 4.Speak接口类
 * speak接口
 * 5.PingPangPlayer
 * 属性
 * 方法 eat重写 study重写 spe
 * 方法 eat重写 study重写 speak重写
 * 7.PingPangCoach
 * 属性
 * 方法 eat重写 coatch重写 speak重写
 * 8.BasketballCoach
 * 属性
 * 方法 eat重写 coatch重写 speak重写
 */
public class Demo02 {
    public static void main(String[] args) {
        //1.测试乒乓球员全参
        // 创建对象并赋值
        PingPangPlayer pp1 = new PingPangPlayer("张怡宁", 32);
        // 打印输出
        System.out.println(pp1.getName() + ".." + pp1.getAge());
        // 调用方法
        pp1.eat();
        pp1.study();
        pp1.speak();
        System.out.println("----------------");
        //2测试抽象类多态
        // 创建Player多态
        Player p1 = new BasketballPlayer("乔丹", 50);
        System.out.println(p1.getName() + ".." + p1.getAge());
        p1.eat();
        p1.study();
        System.out.println("----------------");
        //3.测试接口多态
        Speak s1 = new PingPangPlayer("丁宁", 32);
        s1.speak();
        System.out.println("----------------");


    }
}

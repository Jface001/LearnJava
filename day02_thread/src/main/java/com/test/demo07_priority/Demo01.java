package com.test.demo07_priority;

/**
 * @Author: Jface
 * @Date: 2021/5/20 20:12
 * @Desc: 案例: 演示多线程的优先级问题.
 * <p>
 * 涉及到的Thread类中的成员:
 * 成员方法:
 * public int getPriority();       获取线程的优先级.
 * public void setPriority(int i)  设置优先级.
 * 成员常量:
 * public static final int MAX_PRIORITY;       10
 * public static final int MIN_PRIORITY;       1
 * public static final int NORM_PRIORITY;      5, 默认优先级
 */
public class Demo01 {
    public static void main(String[] args) {
        //1.创建线程类对象
        MyThread md1 = new MyThread("飞机");
        MyThread md2 = new MyThread("高铁");
        MyThread md3 = new MyThread("汽车");
        //2.设置线程优先级
        md1.setPriority(1);
        md2.setPriority(10);
        System.out.println(md3.getPriority());//默认线程登记是5.
        //3.开启线程
//        md1.start();
//        md2.start();
//        md3.start();


    }
}

package com.test.demo09_daemon;

/**
 * @Author: Jface
 * @Date: 2021/5/20 20:29
 * @Desc:
 */
//1.定义一个线程类,继承Thread类,重写run方法
public class MyThread extends Thread {
    //1.成员属性,不需要使用
    //2.空参全参构造

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }
    //3.getXxx()  和SetXxx()方法,不需要,不写
    //4.重写run方法

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "run.." + i);
        }
    }
}

package com.test.demo07_priority;

/**
 * @Author: Jface
 * @Date: 2021/5/20 20:13
 * @Desc:
 */
//1.自定义一个线程类,继承Thread类,并重写run方法
public class MyThread extends Thread {
    //2.成员属性,全部私有,没有需要使用的成员属性
    //3.构造方法,空参和全参

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    //4.getXxx() 和setXxx()省略
    //5.成员方法,重写run方法

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "run.." + i);
        }
    }
}

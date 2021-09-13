package com.test.demo09_daemon;

/**
 * @Author: Jface
 * @Date: 2021/5/20 20:28
 * @Desc: 案例: 演示守护线程.
 * 涉及到的Thread类中的成员方法:
 * public void setDaemon(boolean flag) 设置线程的类别, true: 守护线程, false: 非守护线程(默认)
 * 细节:
 * 每一个线程默认都是非守护线程, 当非守护线程关闭(结束)的时候, 和它相关的守护线程都要自动关闭.
 */

public class Demo01 {
    public static void main(String[] args) {
        //1.创建线程对象并设置姓名
        MyThread md2 = new MyThread("张飞");
        MyThread md3 = new MyThread("关羽");
        //2.设置守护线程
        md2.setDaemon(true);
        md3.setDaemon(true);
        //3.设置当前线程为"刘备".
        Thread.currentThread().setName("刘备");
        //3.启动线程
        md2.start();
        md3.start();
        //循环测试,观测结果规律,刘备结束了,其它守护线程有延迟,但也会立即结束.
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "main...." + i);
        }

    }
}

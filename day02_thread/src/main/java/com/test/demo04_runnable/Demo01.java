package com.test.demo04_runnable;

/**
 * @Author: Jface
 * @Date: 2021/5/20 19:46
 * @Desc: 案例: 多线程模拟卖票, 4个窗口卖100张票.  实现Runnable接口版.
 */
public class Demo01 {
    public static void main(String[] args) {
        //1.创建资源类对象
        MyRunnable mb = new MyRunnable();
        //2.创建线程类对象
        Thread md1 = new Thread(mb, "窗口1");
        Thread md2 = new Thread(mb, "窗口2");
        Thread md3 = new Thread(mb, "窗口3");
        Thread md4 = new Thread(mb, "窗口4");
        //3.开启线程
        md1.start();
        md2.start();
        md3.start();
        md4.start();


    }
}

package com.test.demo03_tickets_synchronized;

/**
 * @Author: Jface
 * @Date: 2021/5/20 14:21
 * @Desc: package com.test.demo03_tickets_synchronized;
 * <p>
 * /*
 * 案例: 多线程模拟卖票, 4个窗口卖100张票.    继承Thread类的方式实现.
 * <p>
 * 两个细节:
 * 1. 四个窗口共享这100张票, 即: 假设13号票从3号窗口售出后, 其它窗口无法售卖此票.
 * 2. 不一定每个窗口都有票卖, 即: 你排2号窗口不一定能买到票.
 * <p>
 * 出现的问题:
 * 出现负数票和重复值.
 * 问题原因:
 * 负数票: 略, 详见上个视频.
 * 重复值: 略, 详见上个视频.
 * 解决方案:
 * 采用同步代码块解决, 即: 加锁的思想, 让某个一个线程在卖某一张票的过程中, 不会收到其他线程的影响.
 * <p>
 * 同步详解:
 * 概述:
 * 多线程环境 并发 操作同一数据, 就有可能引发安全问题, 此时就需要通过同步思想来解决.
 * 分类:
 * 同步代码块:
 * 格式:
 * synchronized(锁对象) {
 * //要加锁的代码
 * }
 * 细节:
 * 1. 同步代码块的锁对象可以是任意类型的对象.
 * 2. 必须使用同一把锁, 否则可能出现锁不住的情况.
 * 同步方法:
 * 格式:
 * 就是在定义方法的时候, 在方法的声明上(返回值类型之前)加上 synchronized 即可.
 * 分类:
 * 静态成员方法:     锁对象是该类的字节码文件对象.
 * 非静态成员方法:    锁对象是 this
 */
public class Demo01 {
    public static void main(String[] args) {
        //6.创建线程对象
        MyThread md1 = new MyThread("窗口1");
        MyThread md2 = new MyThread("窗口2");
        MyThread md3 = new MyThread("窗口3");
        MyThread md4 = new MyThread("窗口4");
        //7.开启线程
        md1.start();
        md2.start();
        md3.start();
        md4.start();

    }
}

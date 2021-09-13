package com.test.demo02_tickets;

/**
 * @Author: Jface
 * @Date: 2021/5/20 12:59
 * @Desc: 案例: 多线程模拟卖票, 4个窗口卖100张票.    继承Thread类的方式实现.
 * <p>
 * 两个细节:
 * 1. 四个窗口共享这100张票, 即: 假设13号票从3号窗口售出后, 其它窗口无法售卖此票.
 * 2. 不一定每个窗口都有票卖, 即: 你排2号窗口不一定能买到票.
 * 出现的问题:
 * 出现负数票和重复值.
 * 问题原因:
 * 负数票:
 * 当ticket的值等于1的时候, 此时不管哪个线程抢到资源, 都会越过if判断, 然后停留在休眠线程这里,
 * 而休眠线程的特点是: 在哪里睡, 到点后就在哪里醒来, 此时四个线程依次醒来, 开始抢资源, 就会出现如下的情况:
 * 假设窗口1先抢到资源, 此时会打印: 窗口1正在售卖第 1 张票, 之后执行ticket--, 最终ticket = 0
 * 假设窗口2后抢到资源, 此时会打印: 窗口2正在售卖第 0 张票, 之后执行ticket--, 最终ticket = -1
 * 假设窗口3后抢到资源, 此时会打印: 窗口3正在售卖第 -1 张票, 之后执行ticket--, 最终ticket = -2
 * 假设窗口4后抢到资源, 此时会打印: 窗口4正在售卖第 -2 张票, 之后执行ticket--, 最终ticket = -3
 * 重复值:
 * 它的出现和 ticket-- 这行代码相关, 它等价于: ticket = ticket - 1, 这行代码做了 3 件事儿:
 * 1. 读取ticket的值.
 * 2. 修改ticket的值, 即: -1
 * 3. 重新赋值.
 * 当某个窗口打印完票数之后, 还没有来得及执行 3(重新赋值)的时候, 被别的线程抢走了资源, 就会打印重复值.
 * <p>
 * 解决方案:
 * 采用同步代码块实现.
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

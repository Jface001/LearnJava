package com.test.demo03_tickets_synchronized;

/**
 * @Author: Jface
 * @Date: 2021/5/20 13:04
 * @Desc:
 */
//自定义一个线程类,继承Thread类.
public class MyThread extends Thread {
    //1.属性,全部私有
    private static int ticket = 100;//静态属性,可以直接调用
    //2.构造方法.空参和全参

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }


    //3.getXXX() setXxx()
    //需要不需要设置,可以不写
    //4.成员方法,重写run()方法

    @Override
    public void run() {
        //5.正常的卖票逻辑
        //5.1越界处理,没票就不卖了.
        //***售票开始***
        while (true) {
            synchronized (MyThread.class) {
                if (ticket <= 0)
                    break;
                // 5.2 休眠线程,指定时间,单位是毫秒. 到点后,在哪里睡着的,在哪里起床
                //***售票开始***
                try {
                    Thread.sleep(50);//线程1, 线程2, 线程3, 线程4
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //5.3正常的售票逻辑
                System.out.println(getName() + " 正在售出第 " + ticket-- + " 张票");
            }
            //***售票结束***
        }
    }
}

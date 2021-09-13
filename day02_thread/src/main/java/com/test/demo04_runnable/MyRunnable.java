package com.test.demo04_runnable;

import com.sun.deploy.net.proxy.ProxyUnavailableException;

/**
 * @Author: Jface
 * @Date: 2021/5/20 19:47
 * @Desc:
 */
//1.定义一个资源类MyRunnable,继承Runnable接口,重写run接口
public class MyRunnable implements Runnable {
    //2.成员属性,全部私有
    private int ticket = 1000;//可以省略static 因为只调用一个

    //3.构造方法,空参和全参,默认空参,可以不写.
    //4.getXxx() 和SetXxx(),可以省略
    //5.成员方法, 重写方法
    //5,1 越界处理
    @Override
    public void run() {
        while (true) {
            synchronized (MyRunnable.class) {
                if (ticket <= 0)
                    break;
                //5.2正常的卖票逻辑
                System.out.println(Thread.currentThread().getName() + "正在售卖第 " + ticket-- + " 张票");
            }

        }
    }
}

package com.test.demo12_customer;

/**
 * @Author: Jface
 * @Date: 2021/5/22 11:14
 * @Desc:
 */
//生产者类(Producer, 资源类)：实现Runnable接口，重写run()方法，调用存储牛奶的操作
public class Producer implements Runnable {
    //1.定义成员变量,记录奶箱(共享数据区)
    private Box b;
    //2.定义构造芳芳,具体传入奶箱的动作

    public Producer(Box b) {
        this.b = b ;
    }

    //3.重写run()方法


    @Override
    public void run() {
        for (int i = 1; i <=31; i++) {
            b.put(i);
        }
    }
}

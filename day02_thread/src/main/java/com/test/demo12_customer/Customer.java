package com.test.demo12_customer;

/**
 * @Author: Jface
 * @Date: 2021/5/22 11:10
 * @Desc:
 */
// 消费者类(Customer)：实现Runnable接口，重写run()方法，调用获取牛奶的操作
public class Customer implements Runnable {
    //1.定义变量,记录奶箱(数据共享区)
    private Box b;
    //2.定义构造方法,具体传入奶箱对象

    public Customer(Box b) {
        this.b = b;
    }

    //3.重写run()方法
    @Override
    public void run() {
        while (true)
            b.get();

    }
}

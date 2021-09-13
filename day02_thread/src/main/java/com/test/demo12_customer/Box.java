package com.test.demo12_customer;

/**
 * @Author: Jface
 * @Date: 2021/5/22 11:13
 * @Desc:
 */
//顶一个一个奶箱类,定义一个成员变量,表示放入的是第x瓶奶,定义成员方法放奶和取奶的动作
public class Box {
    //1.定义成员变量,外部不需要使用,所以都私有
    private int milk;//记录第几瓶奶  这里也变成5
    private boolean state = false;//记录奶箱状态,false是无奶, true是有奶
    //2.构造方法,空参和全参,不需要可以省略

    //3.getXxx() 和setXxx(),不需要可以省略

    //4.成员方法,放奶动作和取奶动作
    //放奶动作,先判断是否无奶,有奶就等等,无奶就放
    public synchronized void put(int milk) {//加锁
        if (state) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //走这里说明奶箱无奶
        System.out.println("送奶工正在放入第 " + milk + " 瓶奶");//如果是5
        state = true;//修改奶箱状态
        this.notify();//随机唤醒
        this.milk = milk;//外面传入的数量赋值给成员变量,记录第几瓶奶.//把5传给上面


    }


    //取奶动作
    public synchronized void get() {//加锁
        if (state) {
            //走这里说明奶箱有奶,就取走
            System.out.println("消费者正在取走第 " + milk + " 瓶奶");
            state = false;//修改状态
            this.notify();
        }
        //走这里说明奶箱无奶,就等待
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}

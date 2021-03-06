package com.test.demo12_customer;

/**
 * @Author: Jface
 * @Date: 2021/5/22 11:09
 * @Desc: 案例: 消费者设计模式详解.
 * 需求:
 * 奶箱类(Box)：定义一个成员变量，表示第x瓶奶，提供存储牛奶和获取牛奶的操作
 * 生产者类(Producer)：实现Runnable接口，重写run()方法，调用存储牛奶的操作
 * 消费者类(Customer)：实现Runnable接口，重写run()方法，调用获取牛奶的操作
 * 测试类(BoxDemo)：里面有main方法，main方法中的代码步骤如下
 * ①创建奶箱对象，这是共享数据区域
 * ②创建生产者对象，把奶箱对象作为构造方法参数传递，因为在这个类中要调用存储牛奶的操作
 * ③创建消费者对象，把奶箱对象作为构造方法参数传递，因为在这个类中要调用获取牛奶的操作
 * ④创建2个线程对象，分别把生产者对象和消费者对象作为构造方法参数传递
 * ⑤启动线程
 * 设计模式简介:
 * 概述:
 * 所谓的设计模式不独属于任何的单一语言, 它是前辈们的经验和总结, 是一系列解决问题的思路和方案.
 * 分类:
 * 创建型:
 * 特点:
 * 顾名思义, 需要创建对象.
 * 例如:
 * 单例设计模式, 原型设计模式, 工厂方法设计模式, 抽象工厂设计模式, 建造者设计模式.
 * 结构型:
 * 特点:
 * 就是用来表述事物与事物之间的关系的.
 * 例如:
 * 装饰设计模式, 适配器设计模式...
 * 装饰类                                       被装饰的类
 * BufferedReader br = new BufferedReader(new FileReader("day13/data/1.txt"));
 * 行为型:
 * 特点:
 * 描述事物能够做什么.
 * 例如:
 * 模板方法设计模式, 观察者, 访问者, 中介者(也叫: 消费者)...
 * 结论:
 * 设计模式一共有 23 种, 分为3大类, 即: 创建型(5种), 结构型(7种), 行为型(11种)
 */
//测试类(BoxDemo)：里面有main方法，main方法中的代码步骤如下
public class Demo01 {
    public static void main(String[] args) throws Exception {
//①创建奶箱对象，这是共享数据区域
        Box b = new Box();
//②创建生产者对象，把奶箱对象作为构造方法参数传递，因为在这个类中要调用存储牛奶的操作
        Producer p = new Producer(b);
//③创建消费者对象，把奶箱对象作为构造方法参数传递，因为在这个类中要调用获取牛奶的操作
        Customer c = new Customer(b);
//④创建2个线程对象，分别把生产者对象和消费者对象作为构造方法参数传递
        Thread td1 = new Thread(p);
        Thread td2 = new Thread(c);
//⑤启动线程
        td1.start();
        td2.start();
    }
}
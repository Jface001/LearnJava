package com.test.demo01_properties;

import java.io.*;
import java.util.Properties;

/**
 * @Author: Jface
 * @Date: 2021/5/23 13:12
 * @Desc: 补充知识: Properties案例.
 * Properties简介:
 * 概述:
 * 它是一个集合类, 是Hashtable的子类, 一般用来操作属性集的, 即: 结合配置文件使用, 且它的键值都是String类型.
 * 它是唯一一个可以和IO流直接相结合使用的集合类, 它可以直接从流中读取数据, 或者直接写入集合数据到文件中.
 * 涉及到的成员方法:
 * setProperty(String key, String value);        添加元素到Properties集合中, 类似于: Map#put()
 * getProperty(String key);      根据键获取值, 类似于: Map#get()
 * <p>
 * load(InputStream is); 从流中(文件中)直接加载数据到 Properties集合中.
 * load(Reader r);   从流中(文件中)直接加载数据到 Properties集合中.
 * <p>
 * store(OutputStream os, String comments);  把集合中的数据直接写入到数据中, 第二个参数表示: 为什么修改配置文件, 即: 原因, 一般写 null
 * store(Writer w, String comments); 把集合中的数据直接写入到数据中, 第二个参数表示: 为什么修改配置文件, 即: 原因, 一般写 null
 * <p>
 * 细节:
 * 和Properties集合类相结合使用的文件, 一般都是配置文件(即: 后缀名为.properties的文件), 即: 键值对形式的数据.
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //需求1: 演示Properties入门.
        //method01();
        //method02();
        //需求3: 演示集合数据写入到文件中.
        //1. 创建集合对象.
        Properties pp = new Properties(System.getProperties());
        //2. 加载配置文件中的数据到集合中.
        pp.load(new FileReader("day16/src/my.properties"));
        //3. 打印集合对象.
        System.out.println("修改之前: " + pp);
        System.out.println("-----------------------");
        //4. 修改集合数据.
        pp.setProperty("game", "LOL");
        System.out.println("修改之后: " + pp);
        //5. 把修改后的数据, 重新写回到配置文件中,后面写修改原因,一般写"null"
        pp.store(new FileWriter("day16/src/my.properties"), null);


    }

    private static void method02() throws IOException {
        //需求2: 演示集合从(配置)文件中直接读取数据.
        //1. 创建集合对象.
        Properties pp = new Properties();
        //2.加载配置文件中的数据到集合中.
        pp.load(new FileInputStream("day16/src/my.properties"));
        //3.打印集合对象.
        System.out.println(pp);
        System.out.println(pp.getProperty("name"));
    }

    private static void method01() {
        //1. 创建集合对象.
        Properties pp = new Properties();
        //2.加载配置文件中的数据到集合中.
        pp.put("username", "password");
        pp.put("root", "pw123");
        //3.打印集合对象.
        System.out.println(pp);
    }
}


//1. 创建集合对象.

//2. 加载配置文件中的数据到集合.

//3. 打印集合对象.


//1. 创建集合.

//2. 添加元素.

//3. 根据键获取值.
//4. 打印集合元素.






